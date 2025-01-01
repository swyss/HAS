package com.has.backend.echostream.models.core;

import com.has.backend.echostream.models.device.*;
import com.has.backend.echostream.models.shared.BaseModel;
import com.has.backend.echostream.models.shared.StatusFactory;
import com.has.backend.echostream.models.shared.core.HAS_SysId;
import com.has.backend.echostream.models.shared.core.HAS_Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = HAS_Device.HAS_DEVICE_TABLE)
public class HAS_Device extends BaseModel {

    public static final String HAS_DEVICE_TABLE = "has_device";
    public static final String COL_SERIAL_NUMBER = "serial_number";
    public static final String COL_DEVICE_GROUP_ID = "device_group_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime createDate; // Renamed from crateDate to createDate

    @Column(name = COL_SERIAL_NUMBER, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = COL_DEVICE_GROUP_ID)
    private DeviceGroup deviceGroup;

    @OneToMany(mappedBy = "has_device", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ActuatorCommand> actuatorCommands = new HashSet<>(); // Moved initialization here

    @OneToMany(mappedBy = "has_device", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DataPoint> dataPoints = new HashSet<>();

    @OneToMany(mappedBy = "has_device", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SensorData> sensorData = new HashSet<>();

    @OneToOne(mappedBy = "has_device", cascade = CascadeType.ALL, orphanRemoval = true)
    private DeviceCharacteristics deviceCharacteristics;

    // Default Constructor
    public HAS_Device() {
        super();
    }

    // Constructor with parameters
    private HAS_Device(HAS_SysId has_sysId, HAS_Type has_type) {
        super(has_sysId, StatusFactory.getStatusForType(has_type), has_type);
    }

    // Static factory method for better expressivity
    public static HAS_Device createWithType(HAS_SysId has_sysId, HAS_Type has_type) {
        return new HAS_Device(has_sysId, has_type);
    }
}