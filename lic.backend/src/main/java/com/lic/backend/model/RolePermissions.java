package com.lic.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "role_permissions")
public class RolePermissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolePermissionId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Roles role; // Reference to Roles entity

    @Column(nullable = false, length = 100)
    private String permission; // Specific permission (e.g., "View Policies", "Manage Users")

    @Column(length = 255)
    private String description; // Description of the permission

    // Getters and Setters

    public Long getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
