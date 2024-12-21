package com.has.backend.echostream.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device; // Associated device

    private String type; // Temperature, Humidity, etc.
    private Double value; // Sensor reading value

    @Column(nullable = false)
    private LocalDateTime timestamp; // Time of data capture
}

