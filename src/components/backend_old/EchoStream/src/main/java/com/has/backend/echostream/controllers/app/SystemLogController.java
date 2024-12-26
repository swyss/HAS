package com.has.backend.echostream.controllers.app;

import com.has.backend.echostream.models.app.SystemLog;
import com.has.backend.echostream.services.app.SystemLogService;
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
