package com.has.backend.echostream.repos.log;

import com.has.backend.echostream.models.log.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiLogRepository extends JpaRepository<ApiLog, Long> {
}

