package com.has.backend.echostream.models.core;

import com.has.backend.echostream.models.shared.BaseModel;
import com.has.backend.echostream.models.shared.StatusFactory;
import com.has.backend.echostream.models.shared.core.HAS_SysId;
import com.has.backend.echostream.models.shared.core.HAS_Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = HAS_Equipment.HAS_EQUIPMENT_TABLE) // Use constant for table name
public class HAS_Equipment extends BaseModel {

    // Static constant for table name
    public static final String HAS_EQUIPMENT_TABLE = "has_equipment";

    // Static constants for column names
    public static final String COL_ID = "equipment_id";
    public static final String COL_NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COL_ID, nullable = false, updatable = false)
    private Long id;

    @Column(name = COL_NAME, nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime createDate; // Renamed for consistency with other classes

    /**
     * Protected constructor for enforcing controlled initialization.
     * This also centralizes `super` invocation logic.
     */
    protected HAS_Equipment(HAS_SysId hasSysId, HAS_Type hasType) {
        super(hasSysId, StatusFactory.getStatusForType(hasType), hasType);
    }

    /**
     * Public default constructor required by JPA.
     */
    public HAS_Equipment() {
        super(null, null, null);
    }

    /**
     * Static factory method for creating a new instance with specific parameters.
     * Provides better readability and avoids direct usage of the parameterized constructor.
     */
    public static HAS_Equipment createWithType(HAS_SysId hasSysId, HAS_Type hasType) {
        return new HAS_Equipment(hasSysId, hasType);
    }
}