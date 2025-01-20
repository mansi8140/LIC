package com.lic.backend.repository;

import com.lic.backend.model.RolePermissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermissions, Long> {
    // Fetch permissions by Role ID
    List<RolePermissions> findByRole_RoleId(Long roleId);

    // Fetch permissions by Role Name
    List<RolePermissions> findByRole_RoleName(String roleName);
}
