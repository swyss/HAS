package com.has.core_backend.echostream.repos.log;

import com.has.core_backend.echostream.models.log.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiLogRepository extends JpaRepository<ApiLog, Long> {
}

