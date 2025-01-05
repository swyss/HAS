package com.has.echostream.backend.repos.log;

import com.has.echostream.backend.models.log.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiLogRepository extends JpaRepository<ApiLog, Long> {
}

