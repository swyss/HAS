package com.has.echostream.backend.models.core;

import com.has.echostream.backend.models.shared.BaseModel;
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
     * Public default constructor required by JPA.
     */
    public HAS_Equipment() {
        super();
    }
}