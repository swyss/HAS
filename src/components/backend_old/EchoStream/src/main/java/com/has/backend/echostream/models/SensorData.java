package com.has.backend.echostream.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    private String type; // e.g., Temperature, Humidity
    private Double value; // Sensor reading value

    @Column(nullable = false)
    private LocalDateTime timestamp; // Timestamp of data capture

    private Boolean isAnomalous; // Indicates if the data is flagged as anomalous

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getIsAnomalous() {
        return isAnomalous;
    }

    public void setIsAnomalous(Boolean isAnomalous) {
        this.isAnomalous = isAnomalous;
    }
}
