package com.has.echostream.backend.repos.log;

import com.has.echostream.backend.models.log.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemLogRepository extends JpaRepository<SystemLog, Long> {
    List<SystemLog> findByLevel(String level);

    List<SystemLog> findByTimestampBetween(java.time.LocalDateTime start, java.time.LocalDateTime end);
}

