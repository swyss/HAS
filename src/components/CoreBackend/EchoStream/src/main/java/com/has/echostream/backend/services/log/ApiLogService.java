package com.has.echostream.backend.services.log;

import com.has.echostream.backend.models.log.ApiLog;
import com.has.echostream.backend.repos.log.ApiLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiLogService {

    private final ApiLogRepository apiLogRepository;

    public ApiLogService(ApiLogRepository apiLogRepository) {
        this.apiLogRepository = apiLogRepository;
    }

    public List<ApiLog> getAllApiLogs() {
        return apiLogRepository.findAll();
    }

    public ApiLog saveApiLog(ApiLog apiLog) {
        return apiLogRepository.save(apiLog);
    }
}

