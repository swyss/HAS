package com.has.backend.echostream.controllers.log;

import com.has.backend.echostream.models.log.SystemLog;
import com.has.backend.echostream.services.log.SystemLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/log/system-logs")
public class SystemLogController {

    private final SystemLogService systemLogService;

    public SystemLogController(SystemLogService systemLogService) {
        this.systemLogService = systemLogService;
    }

    @GetMapping
    public List<SystemLog> getAllSystemLogs() {
        return systemLogService.getAllSystemLogs();
    }

    @GetMapping("/filter")
    public List<SystemLog> getSystemLogsByLevelAndTimeRange(
            @RequestParam String level,
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return systemLogService.getSystemLogsByTimeRange(start, end);
    }
}

