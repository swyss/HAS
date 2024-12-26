package com.has.backend.echostream.models.log;

import com.has.backend.echostream.models.core.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class AuditTrail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String action;
    private String description;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    // Getters and Setters
}

