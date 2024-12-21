package com.has.backend.echostream.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class SystemLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String level; // INFO, WARN, ERROR
    private String message;
    private LocalDateTime timestamp;

    @Column(name = "source", nullable = true)
    private String source; // Optional: e.g., which service generated the log
}
