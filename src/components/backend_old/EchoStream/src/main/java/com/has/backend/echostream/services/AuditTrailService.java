package com.has.backend.echostream.services;

import com.has.backend.echostream.models.AuditTrail;
import com.has.backend.echostream.models.User;
import com.has.backend.echostream.repos.AuditTrailRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditTrailService {
    private final AuditTrailRepository repository;

    public AuditTrailService(AuditTrailRepository repository) {
        this.repository = repository;
    }

    public AuditTrail logAction(User user, String action, String description) {
        AuditTrail trail = new AuditTrail();
        trail.setUser(user);
        trail.setAction(action);
        trail.setDescription(description);
        trail.setTimestamp(LocalDateTime.now());
        return repository.save(trail);
    }

    public List<AuditTrail> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}
