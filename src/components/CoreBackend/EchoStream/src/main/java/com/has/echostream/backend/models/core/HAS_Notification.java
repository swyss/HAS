package com.has.echostream.backend.models.core;

import com.has.echostream.backend.models.shared.BaseModel;
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
     * Default constructor for JPA.
     */
    public HAS_Notification() {
        super();
    }
}