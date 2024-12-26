package com.has.backend.echostream.models.device;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class ActuatorCommand {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    private String command; // e.g., TURN_ON, TURN_OFF

    @Column(nullable = false)
    private LocalDateTime timestamp;

    private String status; // e.g., SUCCESS, FAILED

}

