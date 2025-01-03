package com.has.backend.echostream.models.device;

import com.has.backend.echostream.models.core.HAS_Device;
import com.has.backend.echostream.models.shared.BaseModel;
import com.has.backend.echostream.models.shared.core.HAS_Status;
import com.has.backend.echostream.models.shared.core.HAS_SysId;
import com.has.backend.echostream.models.shared.core.HAS_Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "actuator_command")
public class ActuatorCommand extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actuator_command_id")
    private Long id;

    @Column(nullable = false)
    private String command;

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
    public ActuatorCommand() {
        super();
    }
}