package com.has.backend.echostream.models.device;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Device {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // Sensor, Actuator, etc.
    private String status; // Online, Offline
    private String location;

    @Column(unique = true, nullable = false)
    private String serialNumber;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<SensorData> sensorData;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<ActuatorCommand> actuatorCommands;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private DeviceGroup deviceGroup;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<DataPoint> dataPoints;

}

