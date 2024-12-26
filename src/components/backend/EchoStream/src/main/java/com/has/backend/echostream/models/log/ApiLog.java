package com.has.backend.echostream.models.log;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class ApiLog {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    private String httpMethod; // e.g., GET, POST

    private String endpoint;

    private String clientIp;

    @Lob
    private String requestDetails;

    @Lob
    private String responseDetails;

    private int statusCode;

    private long latency; // in milliseconds

}
