package com.has.core_backend.echostream.repos.user;

import com.has.core_backend.echostream.models.user.AuditTrail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditTrailRepository extends JpaRepository<AuditTrail, Long> {
    List<AuditTrail> findByUserId(Long userId);

    List<AuditTrail> findByAction(String action);
}

