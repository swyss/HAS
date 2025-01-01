package com.has.backend.echostream.models.core;

import com.has.backend.echostream.models.shared.BaseModel;
import com.has.backend.echostream.models.shared.core.HAS_Status;
import com.has.backend.echostream.models.shared.core.HAS_SysId;
import com.has.backend.echostream.models.shared.core.HAS_Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = HAS_Notification.TABLE_NAME)
public class HAS_Notification extends BaseModel {

    // Table name constant
    public static final String TABLE_NAME = "has_notification";

    // Column name constants
    public static final String COLUMN_DEVICE_ID = "device_id";
    public static final String COLUMN_NOTIFICATION_TYPE = "notification_type";
    public static final String COLUMN_NOTIFICATION_STATUS = "notification_status";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    // General notification attributes
    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private boolean isRead;

    @Column(name = COLUMN_NOTIFICATION_TYPE, nullable = false) // Renamed for clarity
    private String notificationType;

    @Column(name = COLUMN_NOTIFICATION_STATUS, nullable = false) // Renamed for clarity
    private String notificationStatus;

    // Relationship column
    @ManyToOne
    @JoinColumn(name = COLUMN_DEVICE_ID)
    private HAS_Device device;

    /**
     * Parameterized constructor for explicit initialization with required values.
     */
    public HAS_Notification(HAS_SysId sysId, HAS_Status status, HAS_Type type, String message,
                            LocalDateTime timestamp, HAS_Device device) {
        super(sysId, status, type);
        this.message = message;
        this.timestamp = timestamp;
        this.notificationType = type.getCoretype(); // Assumes type has a core type
        this.notificationStatus = status.getCurrentStatus(); // Assumes status has a current status
        this.device = device;
    }

    /**
     * Default constructor for JPA.
     */
    public HAS_Notification() {
        super();
    }
}