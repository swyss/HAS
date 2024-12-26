package com.has.backend.echostream.models.device;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class DataPoint {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    private String type; // e.g., Temperature, State

    private Double value;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    private String unit; // e.g., °C, %

    @Lob
    private String metadata; // Optional extra information

}

