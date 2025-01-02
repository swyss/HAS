package com.has.backend.echostream.models.user;

import com.has.backend.echostream.models.core.HAS_User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_trail")
public class
AuditTrail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private HAS_User user;

    private String action;
    private String description;

    @Column(nullable = false)
    private LocalDateTime timestamp;
}

