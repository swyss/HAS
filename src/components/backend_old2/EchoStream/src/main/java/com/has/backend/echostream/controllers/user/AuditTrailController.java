package com.has.backend.echostream.controllers.user;

import com.has.backend.echostream.models.user.AuditTrail;
import com.has.backend.echostream.services.user.AuditTrailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-trails")
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

