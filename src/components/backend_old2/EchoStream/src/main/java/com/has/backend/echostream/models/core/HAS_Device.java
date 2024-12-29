package com.has.backend.echostream.models.core;

import com.has.backend.echostream.models.device.ActuatorCommand;
import com.has.backend.echostream.models.device.DataPoint;
import com.has.backend.echostream.models.device.DeviceGroup;
import com.has.backend.echostream.models.device.SensorData;
import com.has.backend.echostream.models.shared.HAS_Status;
import com.has.backend.echostream.models.shared.HAS_Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "has_device")
public class HAS_Device implements HAS_Type, HAS_Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "device_group_id")
    private DeviceGroup device_group;

    @OneToMany(mappedBy = "has_device", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ActuatorCommand> actuatorCommands = new HashSet<>();

    @OneToMany(mappedBy = "has_device", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DataPoint> dataPoints = new HashSet<>();

    @OneToMany(mappedBy = "has_device", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SensorData> sensorData = new HashSet<>();

}