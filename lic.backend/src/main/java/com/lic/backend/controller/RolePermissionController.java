package com.lic.backend.controller;

import com.lic.backend.model.RolePermissions;
import com.lic.backend.repository.RolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role-permissions")
public class RolePermissionController {

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    // Get all role permissions
    @GetMapping
    public ResponseEntity<List<RolePermissions>> getAllRolePermissions() {
        return ResponseEntity.ok(rolePermissionRepository.findAll());
    }

    // Get role permission by ID
    @GetMapping("/{id}")
    public ResponseEntity<RolePermissions> getRolePermissionById(@PathVariable Long id) {
        Optional<RolePermissions> rolePermission = rolePermissionRepository.findById(id);
        return rolePermission.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get permissions by Role ID
    @GetMapping("/role/{roleId}")
    public ResponseEntity<List<RolePermissions>> getPermissionsByRoleId(@PathVariable Long roleId) {
        List<RolePermissions> permissions = rolePermissionRepository.findByRole_RoleId(roleId);
        return ResponseEntity.ok(permissions);
    }

    // Get permissions by Role Name
    @GetMapping("/role-name/{roleName}")
    public ResponseEntity<List<RolePermissions>> getPermissionsByRoleName(@PathVariable String roleName) {
        List<RolePermissions> permissions = rolePermissionRepository.findByRole_RoleName(roleName);
        return ResponseEntity.ok(permissions);
    }

    // Create a new role permission
    @PostMapping
    public ResponseEntity<RolePermissions> createRolePermission(@RequestBody RolePermissions rolePermission) {
        RolePermissions savedRolePermission = rolePermissionRepository.save(rolePermission);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRolePermission);
    }

    // Update a role permission
    @PutMapping("/{id}")
    public ResponseEntity<RolePermissions> updateRolePermission(@PathVariable Long id, @RequestBody RolePermissions permissionDetails) {
        Optional<RolePermissions> optionalRolePermission = rolePermissionRepository.findById(id);

        if (optionalRolePermission.isPresent()) {
            RolePermissions permission = optionalRolePermission.get();
            permission.setRole(permissionDetails.getRole());
            permission.setPermission(permissionDetails.getPermission());
            permission.setDescription(permissionDetails.getDescription());
            RolePermissions updatedPermission = rolePermissionRepository.save(permission);
            return ResponseEntity.ok(updatedPermission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a role permission
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRolePermission(@PathVariable Long id) {
        if (rolePermissionRepository.existsById(id)) {
            rolePermissionRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
