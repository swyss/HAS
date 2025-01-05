package com.has.echostream.backend.repos.core;

import com.has.echostream.backend.models.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByName(String name);
}

