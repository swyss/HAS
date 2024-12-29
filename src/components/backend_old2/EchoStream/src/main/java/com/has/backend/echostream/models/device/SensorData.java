package com.has.backend.echostream.models.device;

import com.has.backend.echostream.models.core.HAS_Device;
import com.has.backend.echostream.models.shared.HAS_Status;
import com.has.backend.echostream.models.shared.HAS_Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sensor_data")
public class SensorData implements HAS_Type, HAS_Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_data_id")
    private Long id;

    @Column(nullable = false)
    private String value;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "has_device_id", nullable = false)
    private HAS_Device has_device;

    @Column(nullable = false)
    Boolean isAnomalous;
}