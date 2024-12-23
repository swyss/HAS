package com.has.backend.echostream.controllers;

import com.has.backend.echostream.models.SystemLog;
import com.has.backend.echostream.services.SystemLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system-logs")
public class SystemLogController {

    private final SystemLogService service;

    public SystemLogController(SystemLogService service) {
        this.service = service;
    }

    @GetMapping
    public List<SystemLog> getAllLogs() {
        return service.findAll();
    }

    @PostMapping
    public SystemLog createLog(@RequestBody SystemLog log) {
        return service.save(log);
    }
}
