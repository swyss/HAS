package com.has.backend.echostream.models.log;

import com.has.backend.echostream.models.device.Device;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Notification {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // e.g., ALERT, INFO

    private String message;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = true)
    private Device device;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    private Boolean isRead;

}

