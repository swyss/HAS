package com.has.backend.echostream.repos;

import com.has.backend.echostream.models.AuditTrail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditTrailRepository extends JpaRepository<AuditTrail, Long> {
    List<AuditTrail> findByUserId(Long userId);
    List<AuditTrail> findByAction(String action);
}