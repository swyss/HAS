package com.has.backend.echostream.services.app;

import com.has.backend.echostream.models.app.SystemLog;
import com.has.backend.echostream.repos.app.SystemLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemLogService {
    private final SystemLogRepository repository;

    public SystemLogService(SystemLogRepository repository) {
        this.repository = repository;
    }

    public List<SystemLog> findAll() {
        return repository.findAll();
    }

    public SystemLog save(SystemLog log) {
        return repository.save(log);
    }
}
