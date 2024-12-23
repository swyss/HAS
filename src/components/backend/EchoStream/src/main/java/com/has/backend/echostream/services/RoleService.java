package com.has.backend.echostream.services;

import com.has.backend.echostream.models.Role;
import com.has.backend.echostream.repos.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // Finds a role by name or creates it if it doesn't exist
    public Role createRole(String roleName) {
        Role existingRole = roleRepository.findByName(roleName);
        if (existingRole != null) {
            return existingRole;
        }
        Role newRole = new Role();
        newRole.setName(roleName);
        return roleRepository.save(newRole);
    }

    // Additional methods can be added as needed
    public Role findRoleByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
