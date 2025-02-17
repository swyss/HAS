package com.has.echostream.backend.controllers.log;

import com.has.echostream.backend.models.log.ApiLog;
import com.has.echostream.backend.services.log.ApiLogService;
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

