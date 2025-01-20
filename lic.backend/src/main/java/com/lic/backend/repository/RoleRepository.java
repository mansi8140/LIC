package com.lic.backend.repository;

import com.lic.backend.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
    // Find role by name
    Roles findByRoleName(String roleName);
}
