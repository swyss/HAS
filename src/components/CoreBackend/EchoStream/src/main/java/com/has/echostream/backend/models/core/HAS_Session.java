package com.has.echostream.backend.models.core;

import com.has.echostream.backend.models.shared.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
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

    /**
     * Public default constructor required by JPA.
     */
    public HAS_Session() {
        super();
    }

}