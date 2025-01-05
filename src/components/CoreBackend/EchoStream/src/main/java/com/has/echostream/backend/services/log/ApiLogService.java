package com.has.core_backend.echostream.services.log;

import com.has.core_backend.echostream.models.log.ApiLog;
import com.has.core_backend.echostream.repos.log.ApiLogRepository;
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

