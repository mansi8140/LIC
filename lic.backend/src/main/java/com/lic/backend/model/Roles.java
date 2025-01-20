package com.lic.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId; // Primary Key

    @Column(nullable = false, unique = true, length = 50)
    private String roleName; // Role name (e.g., Admin, User, Agent)

    @Column(length = 255)
    private String description; // Description of the role

    // Getters and Setters

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
