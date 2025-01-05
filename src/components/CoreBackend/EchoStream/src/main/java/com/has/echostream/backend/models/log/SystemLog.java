package com.has.core_backend.echostream.models.log;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "system_log")
public class SystemLog {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String level; // e.g., INFO, ERROR

    private String message;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    private String source; // e.g., Backend, Gateway

}

