package com.has.backend.echostream.models.app;

import com.has.backend.echostream.models.Device;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ActuatorCommand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    private String command; // Command type (e.g., TURN_ON, TURN_OFF)

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = true)
    private String status; // Optional: SUCCESS, FAILED

    // Getter & Setter
}

