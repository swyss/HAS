package com.has.echostream.backend.controllers.user;

import com.has.echostream.backend.models.user.UserRole;
import com.has.echostream.backend.services.core.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<UserRole> createRole(@RequestBody String roleName) {
        UserRole userRole = roleService.createRole(roleName);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRole);
    }

    @GetMapping("/{name}")
    public ResponseEntity<UserRole> getRoleByName(@PathVariable String name) {
        UserRole userRole = roleService.findRoleByName(name);
        return ResponseEntity.ok(userRole);
    }
}

