package com.has.core_backend.echostream.controllers.log;

import com.has.core_backend.echostream.models.log.ApiLog;
import com.has.core_backend.echostream.services.log.ApiLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/log/api-logs")
public class ApiLogController {

    private final ApiLogService apiLogService;

    public ApiLogController(ApiLogService apiLogService) {
        this.apiLogService = apiLogService;
    }

    @GetMapping
    public List<ApiLog> getAllApiLogs() {
        return apiLogService.getAllApiLogs();
    }
}

