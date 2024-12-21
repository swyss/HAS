package com.has.backend.echostream.interceptor;
import com.has.backend.echostream.models.ApiLog;
import com.has.backend.echostream.repos.ApiLogRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class ApiLoggingInterceptor implements HandlerInterceptor {

    private final ApiLogRepository apiLogRepository;

    public ApiLoggingInterceptor(ApiLogRepository apiLogRepository) {
        this.apiLogRepository = apiLogRepository;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true; // Continue with the request
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        long latency = System.currentTimeMillis() - startTime;

        // Create API Log entry
        ApiLog apiLog = new ApiLog();
        apiLog.setTimestamp(LocalDateTime.now());
        apiLog.setHttpMethod(request.getMethod());
        apiLog.setEndpoint(request.getRequestURI());
        apiLog.setClientIp(getClientIp(request));
        apiLog.setRequestDetails(getRequestBody(request));
        apiLog.setResponseDetails("Response logged here"); // Placeholder
        apiLog.setStatusCode(response.getStatus());
        apiLog.setLatency(latency);

        // Save to database
        apiLogRepository.save(apiLog);

        // Log to console
        System.out.println(buildConsoleLog(apiLog));
    }

    private String getClientIp(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-Forwarded-For");
        return (remoteAddr != null) ? remoteAddr.split(",")[0] : request.getRemoteAddr();
    }

    private String getRequestBody(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    private String buildConsoleLog(ApiLog apiLog) {
        return String.format(
                "[API LOG] Timestamp: %s | Method: %s | Endpoint: %s | Client IP: %s | Status: %d | Latency: %d ms",
                apiLog.getTimestamp(),
                apiLog.getHttpMethod(),
                apiLog.getEndpoint(),
                apiLog.getClientIp(),
                apiLog.getStatusCode(),
                apiLog.getLatency()
        );
    }
}