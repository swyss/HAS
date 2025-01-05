package com.has.core_backend.echostream.services.user;

import com.has.core_backend.echostream.models.user.AuditTrail;
import com.has.core_backend.echostream.repos.user.AuditTrailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditTrailService {

    private final AuditTrailRepository auditTrailRepository;

    public AuditTrailService(AuditTrailRepository auditTrailRepository) {
        this.auditTrailRepository = auditTrailRepository;
    }

    public List<AuditTrail> getAllAuditTrails() {
        return auditTrailRepository.findAll();
    }

    public List<AuditTrail> getAuditTrailsByUserId(Long userId) {
        return auditTrailRepository.findByUserId(userId);
    }

    public List<AuditTrail> getAuditTrailsByAction(String action) {
        return auditTrailRepository.findByAction(action);
    }

    public AuditTrail saveAuditTrail(AuditTrail auditTrail) {
        return auditTrailRepository.save(auditTrail);
    }
}

