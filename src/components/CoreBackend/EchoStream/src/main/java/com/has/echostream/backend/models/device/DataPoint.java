package com.has.core_backend.echostream.models.device;

import com.has.core_backend.echostream.models.core.HAS_Device;
import com.has.core_backend.echostream.models.shared.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "data_point")
public class DataPoint extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_point_id")
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

    /**
     * Public default constructor required by JPA.
     */
    public DataPoint() {
        super();
    }
}