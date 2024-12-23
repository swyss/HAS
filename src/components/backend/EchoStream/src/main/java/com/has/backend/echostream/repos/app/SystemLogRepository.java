package com.has.backend.echostream.repos;

import com.has.backend.echostream.models.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemLogRepository extends JpaRepository<SystemLog, Long> {
}
