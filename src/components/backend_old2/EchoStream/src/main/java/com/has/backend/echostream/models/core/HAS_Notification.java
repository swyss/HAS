package com.has.backend.echostream.models.core;

import com.has.backend.echostream.models.shared.HAS_Status;
import com.has.backend.echostream.models.shared.HAS_Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "has_notification")
public class HAS_Notification implements HAS_Type, HAS_Status {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = true)
    private HAS_Device device;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    private Boolean isRead;

}

