package com.has.backend.echostream.repos.core;

import com.has.backend.echostream.models.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByName(String name);
}

