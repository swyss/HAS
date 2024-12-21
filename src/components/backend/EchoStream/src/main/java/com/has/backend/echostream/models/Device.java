package com.has.backend.echostream.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // Sensor, Actuator, etc.
    private String status; // Online, Offline
    private String location;

    @Column(nullable = false, unique = true)
    private String serialNumber; // Unique Identifier for the device
}
