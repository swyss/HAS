package com.has.backend.echostream.repos.app;

import com.has.backend.echostream.models.app.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemLogRepository extends JpaRepository<SystemLog, Long> {
}
