package com.has.backend.echostream.controllers.log;

import com.has.backend.echostream.models.log.ApiLog;
import com.has.backend.echostream.services.log.ApiLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/api-logs")
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

