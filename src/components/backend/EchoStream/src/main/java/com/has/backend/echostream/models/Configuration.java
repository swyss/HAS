package com.has.backend.echostream.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String key; // Configuration key (e.g., "max_devices")

    @Column(nullable = false)
    private String value; // Configuration value
}
