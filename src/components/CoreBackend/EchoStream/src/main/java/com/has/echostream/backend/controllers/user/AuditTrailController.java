package com.has.echostream.backend.controllers.user;

import com.has.echostream.backend.models.user.AuditTrail;
import com.has.echostream.backend.services.user.AuditTrailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/audit-trails")
public class AuditTrailController {

    private final AuditTrailService auditTrailService;

    public AuditTrailController(AuditTrailService auditTrailService) {
        this.auditTrailService = auditTrailService;
    }

    @GetMapping
    public List<AuditTrail> getAllAuditTrails() {
        return auditTrailService.getAllAuditTrails();
    }

    @GetMapping("/user/{userId}")
    public List<AuditTrail> getAuditTrailsByUserId(@PathVariable Long userId) {
        return auditTrailService.getAuditTrailsByUserId(userId);
    }

    @GetMapping("/action/{action}")
    public List<AuditTrail> getAuditTrailsByAction(@PathVariable String action) {
        return auditTrailService.getAuditTrailsByAction(action);
    }
}

