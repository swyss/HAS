package com.has.backend.echostream.models;

import com.has.backend.echostream.services.RoleService;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    // Add this transient field to inject the RoleService for simplicity
    @Transient
    private RoleService roleService;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    // Method to add a single role by name
    public void setRole(String value) {
        if (roleService == null) {
            throw new IllegalStateException("RoleService is not initialized");
        }

        Role role = roleService.createRole(value); // Find or create the role
        this.roles.add(role); // Add the role to the user's set of roles
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
