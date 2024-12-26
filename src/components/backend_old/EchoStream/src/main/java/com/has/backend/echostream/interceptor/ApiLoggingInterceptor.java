package com.has.backend.echostream.interceptor;

import com.has.backend.echostream.models.app.ApiLog;
import com.has.backend.echostream.repos.app.ApiLogRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class ApiLoggingInterceptor implements HandlerInterceptor {

    private final ApiLogRepository apiLogRepository;

    // Configuration flag to toggle between detailed and simple logging
    @Value("${app_settings.api.log.detail}")
    private boolean logDetail;

    public ApiLoggingInterceptor(ApiLogRepository apiLogRepository) {
        this.apiLogRepository = apiLogRepository;
    }

    /**
     * Pre-handle method to capture the start time of the request.
     * This will be used later to calculate latency.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true; // Continue with the request
    }

    /**
     * After completion method to log API request details and save them to the database.
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        long latency = System.currentTimeMillis() - startTime;

        // Create an API log object to store request and response details
        ApiLog apiLog = new ApiLog();
        apiLog.setTimestamp(LocalDateTime.now());
        apiLog.setHttpMethod(request.getMethod());
        apiLog.setEndpoint(request.getRequestURI());
        apiLog.setClientIp(getClientIp(request));
        apiLog.setRequestDetails(logDetail ? getRequestBody(request) : "Details omitted");
        apiLog.setResponseDetails(logDetail ? "Response logged here" : "Details omitted");
        apiLog.setStatusCode(response.getStatus());
        apiLog.setLatency(latency);

        // Save the log to the database
        apiLogRepository.save(apiLog);

        // Print log details to the console
        System.out.println(buildConsoleLog(apiLog));
    }

    /**
     * Extracts the client IP address from the request headers or the remote address.
     */
    private String getClientIp(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-Forwarded-For");
        return (remoteAddr != null) ? remoteAddr.split(",")[0] : request.getRemoteAddr();
    }

    /**
     * Reads and returns the request body as a string.
     */
    private String getRequestBody(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    /**
     * Builds the console log message with optional colors and details based on the configuration.
     */
    private String buildConsoleLog(ApiLog apiLog) {
        // ANSI escape codes for colored console output
        String resetColor = "\u001B[0m";
        String greenColor = "\u001B[32m";
        String yellowColor = "\u001B[33m";
        String redColor = "\u001B[31m";
        String cyanColor = "\u001B[36m";

        if (!logDetail) {
            // Simple log format
            return String.format(
                    "%s[API LOG]%s Timestamp: %s | Endpoint: %s%s%s  | Status: %s%s%s | Latency: %sms",
                    cyanColor, resetColor,
                    apiLog.getTimestamp(),
                    yellowColor,apiLog.getEndpoint(),resetColor,
                    getStatusColor(apiLog.getStatusCode()), apiLog.getStatusCode(), resetColor,
                    apiLog.getLatency()
            );
        }

        // Detailed log format
        return String.format(
                "%s[API LOG]%s Timestamp: %s | Method: %s | Endpoint: %s | Client IP: %s | Status: %s%s%s | Latency: %sms\nRequest: %s\nResponse: %s",
                cyanColor, resetColor,
                apiLog.getTimestamp(),
                apiLog.getHttpMethod(),
                apiLog.getEndpoint(),
                apiLog.getClientIp(),
                getStatusColor(apiLog.getStatusCode()), apiLog.getStatusCode(), resetColor,
                apiLog.getLatency(),
                apiLog.getRequestDetails(),
                apiLog.getResponseDetails()
        );
    }

    /**
     * Returns the appropriate color code based on the HTTP status code.
     */
    private String getStatusColor(int statusCode) {
        if (statusCode >= 200 && statusCode < 300) {
            return "\u001B[32m"; // Green for successful responses
        } else if (statusCode >= 400 && statusCode < 500) {
            return "\u001B[33m"; // Yellow for client errors
        } else if (statusCode >= 500) {
            return "\u001B[31m"; // Red for server errors
        } else {
            return "\u001B[36m"; // Cyan for other cases
        }
    }
}
