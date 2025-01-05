package com.has.core_backend.echostream.models.device;

import com.has.core_backend.echostream.models.core.HAS_Device;
import com.has.core_backend.echostream.models.shared.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sensor_data")
public class SensorData extends BaseModel {


    @Column(nullable = false)
    Boolean isAnomalous;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_data_id")
    private Long id;
    @Column(nullable = false)
    private String value;
    @ManyToOne
    @JoinColumn(name = "has_device_id", nullable = false)
    private HAS_Device has_device;


    /**
     * Public default constructor required by JPA.
     */
    public SensorData() {
        super();
    }
}