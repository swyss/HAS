package com.has.backend.echostream.interceptor;

import com.has.backend.echostream.models.log.ApiLog;
import com.has.backend.echostream.repos.log.ApiLogRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ApiLoggingInterceptor implements HandlerInterceptor {

    private final ApiLogRepository apiLogRepository;
    // ANSI escape codes for colored console output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Configuration flag to toggle between detailed and simple logging
    @Value("${app_settings.api.log.detail}")
    private boolean logDetail;

    // Timestamp formatter for consistent formatting
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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

        // Format the timestamp
        String formattedTimestamp = apiLog.getTimestamp().format(TIMESTAMP_FORMATTER);

        // Ensure consistent column alignment for the console output
        if (!logDetail) {
            // Simple log format
            return String.format(
                    "%-10s %-20s %-70s %-10s %-10s",
                    ANSI_CYAN + "[API LOG]" + ANSI_RESET,
                    ANSI_PURPLE+"Timestamp: " + ANSI_RESET+ formattedTimestamp,
                    ANSI_PURPLE+"Endpoint: " + ANSI_YELLOW+ "-> * "+ apiLog.getEndpoint().trim()+ " *"+ ANSI_RESET,
                    ANSI_PURPLE+"Status: " + ANSI_RESET+ getStatusColor(apiLog.getStatusCode()) + apiLog.getStatusCode() + ANSI_RESET,
                    ANSI_PURPLE+"Latency: " + ANSI_RESET+ apiLog.getLatency() + "ms"
            );
        }

        // Detailed log format
        return String.format(
                "%-10s %-20s %-70s %-10s %-10s\nRequest: %s\nResponse: %s",
                ANSI_CYAN + "[API LOG]" + ANSI_RESET,
                ANSI_PURPLE+"Timestamp: " + ANSI_RESET+ formattedTimestamp,
                ANSI_PURPLE+"Method: " +ANSI_RESET+ apiLog.getHttpMethod(),
                ANSI_PURPLE+"Endpoint: " + ANSI_YELLOW+ "-> * "+ apiLog.getEndpoint().trim()+ " *"+ ANSI_RESET,
                ANSI_PURPLE+"Status: " + ANSI_RESET+ getStatusColor(apiLog.getStatusCode()) + apiLog.getStatusCode() + ANSI_RESET,
                apiLog.getRequestDetails(),
                apiLog.getResponseDetails()
        );
    }

    /**
     * Returns the appropriate color code based on the HTTP status code.
     */
    private String getStatusColor(int statusCode) {
        if (statusCode >= 200 && statusCode < 300) {
            return ANSI_GREEN; // Green for successful responses
        } else if (statusCode >= 400 && statusCode < 500) {
            return ANSI_YELLOW; // Yellow for client errors
        } else if (statusCode >= 500) {
            return ANSI_RED; // Red for server errors
        } else {
            return ANSI_CYAN; // Cyan for other cases
        }
    }
}
