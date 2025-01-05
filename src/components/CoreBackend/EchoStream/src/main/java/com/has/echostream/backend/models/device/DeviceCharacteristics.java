package com.has.core_backend.echostream.models.device;

import com.has.core_backend.echostream.models.core.HAS_Device;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DeviceCharacteristics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String manufacturer;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String firmwareVersion;
    @Column(nullable = false)
    private String hardwareVersion;
    @Column(nullable = false)
    private String softwareVersion;
    @Column(nullable = false)
    private String ipAddress;
    @Column(nullable = false)
    private String macAddress;

    @OneToOne
    @JoinColumn(name = "has_device_id", nullable = false)
    private HAS_Device has_device;
}
