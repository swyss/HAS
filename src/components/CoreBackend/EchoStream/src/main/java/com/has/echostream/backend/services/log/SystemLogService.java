package com.has.echostream.backend.services.log;

import com.has.echostream.backend.models.log.SystemLog;
import com.has.echostream.backend.repos.log.SystemLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SystemLogService {

    private final SystemLogRepository systemLogRepository;

    public SystemLogService(SystemLogRepository systemLogRepository) {
        this.systemLogRepository = systemLogRepository;
    }

    public List<SystemLog> getAllSystemLogs() {
        return systemLogRepository.findAll();
    }

    public List<SystemLog> getSystemLogsByLevel(String level) {
        return systemLogRepository.findByLevel(level);
    }

    public List<SystemLog> getSystemLogsByTimeRange(LocalDateTime start, LocalDateTime end) {
        return systemLogRepository.findByTimestampBetween(start, end);
    }

    public SystemLog saveSystemLog(SystemLog log) {
        return systemLogRepository.save(log);
    }
}

