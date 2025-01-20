package com.lic.backend.controller;

import com.lic.backend.model.Roles;
import com.lic.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    // Get all roles
    @GetMapping
    public ResponseEntity<List<Roles>> getAllRoles() {
        return ResponseEntity.ok(roleRepository.findAll());
    }

    // Get a role by ID
    @GetMapping("/{id}")
    public ResponseEntity<Roles> getRoleById(@PathVariable Long id) {
        Optional<Roles> role = roleRepository.findById(id);
        return role.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new role
    @PostMapping
    public ResponseEntity<Roles> createRole(@RequestBody Roles role) {
        Roles savedRole = roleRepository.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
    }

    // Update an existing role
    @PutMapping("/{id}")
    public ResponseEntity<Roles> updateRole(@PathVariable Long id, @RequestBody Roles roleDetails) {
        Optional<Roles> optionalRole = roleRepository.findById(id);

        if (optionalRole.isPresent()) {
            Roles role = optionalRole.get();
            role.setRoleName(roleDetails.getRoleName());
            role.setDescription(roleDetails.getDescription());
            Roles updatedRole = roleRepository.save(role);
            return ResponseEntity.ok(updatedRole);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a role
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
