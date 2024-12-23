package com.has.backend.echostream.services;

import com.has.backend.echostream.models.SystemLog;
import com.has.backend.echostream.repos.SystemLogRepository;
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
