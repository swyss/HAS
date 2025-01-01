package com.has.backend.echostream.models.core;

import com.has.backend.echostream.models.shared.BaseModel;
import com.has.backend.echostream.models.shared.core.HAS_Status;
import com.has.backend.echostream.models.shared.core.HAS_SysId;
import com.has.backend.echostream.models.shared.core.HAS_Type;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "has_session")
public class HAS_Session extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private HAS_User user;

    @Column(nullable = false)
    private LocalDateTime startTimestamp;

    @Column(nullable = false)
    private LocalDateTime stopTimestamp;

    @Column(nullable = false)
    private String sessionName;

    @Column(nullable = false)
    private String sessionDescription;

    @Column(nullable = false, unique = true)
    private String token;

    // Main constructor for controlled initialization
    private HAS_Session(HAS_SysId hasSysId, HAS_Status hasStatus, HAS_Type hasType, HAS_User user,
                        LocalDateTime startTimestamp, LocalDateTime stopTimestamp,
                        String sessionName, String sessionDescription, String token) {
        super(hasSysId, hasStatus, hasType);
        this.user = user;
        this.startTimestamp = startTimestamp;
        this.stopTimestamp = stopTimestamp;
        this.sessionName = sessionName;
        this.sessionDescription = sessionDescription;
        this.token = token;
    }

    public HAS_Session() {
        super();
    }

    // Static factory method for encapsulated instance creation
    @Builder
    public static HAS_Session createWithDetails(HAS_SysId hasSysId, HAS_Status hasStatus, HAS_Type hasType, HAS_User user,
                                                LocalDateTime startTimestamp, LocalDateTime stopTimestamp,
                                                String sessionName, String sessionDescription, String token) {
        return new HAS_Session(hasSysId, hasStatus, hasType, user, startTimestamp, stopTimestamp, sessionName, sessionDescription, token);
    }
}