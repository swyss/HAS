package com.has.echostream.backend.models.core;

import com.has.echostream.backend.models.shared.BaseModel;
import com.has.echostream.backend.models.user.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = HAS_User.TABLE_NAME)
public class HAS_User extends BaseModel {

    // Constants
    public static final String TABLE_NAME = "has_user";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID, nullable = false, updatable = false)
    private Long id;

    @Column(name = COLUMN_USERNAME, nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<UserRole> userRoles = new HashSet<>(); // Moved initialization here

    /**
     * Public default constructor required by JPA.
     */
    public HAS_User() {
        super();
    }

}