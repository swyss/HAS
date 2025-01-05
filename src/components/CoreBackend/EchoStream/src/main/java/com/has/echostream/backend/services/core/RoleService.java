package com.has.echostream.backend.services.core;

import com.has.echostream.backend.models.user.UserRole;
import com.has.echostream.backend.repos.core.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UserRole createRole(String roleName) {
        UserRole existingUserRole = roleRepository.findByName(roleName);
        if (existingUserRole != null) {
            return existingUserRole;
        }
        UserRole newUserRole = new UserRole();
        newUserRole.setName(roleName);
        return roleRepository.save(newUserRole);
    }

    public UserRole findRoleByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}

