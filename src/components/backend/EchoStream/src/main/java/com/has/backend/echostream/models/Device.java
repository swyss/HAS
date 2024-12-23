package com.has.backend.echostream.models;

import com.has.backend.echostream.models.app.ActuatorCommand;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // Sensor, Actuator, etc.
    private String status; // Online, Offline
    private String location;

    @Column(nullable = false, unique = true)
    private String serialNumber;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<SensorData> sensorData;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<ActuatorCommand> actuatorCommands;

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<SensorData> getSensorData() {
        return sensorData;
    }

    public void setSensorData(List<SensorData> sensorData) {
        this.sensorData = sensorData;
    }

    public List<ActuatorCommand> getActuatorCommands() {
        return actuatorCommands;
    }

    public void setActuatorCommands(List<ActuatorCommand> actuatorCommands) {
        this.actuatorCommands = actuatorCommands;
    }
}
