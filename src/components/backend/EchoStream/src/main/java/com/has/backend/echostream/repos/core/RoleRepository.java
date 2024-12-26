package com.has.backend.echostream.repos.core;

import com.has.backend.echostream.models.core.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

