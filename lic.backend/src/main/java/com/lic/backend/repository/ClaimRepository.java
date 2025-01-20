package com.lic.backend.repository;

import com.lic.backend.model.Claims;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claims, Long> {
    // Fetch claims by User Policy ID
    List<Claims> findByUserPolicy_UserPolicyId(Long userPolicyId);

    // Fetch claims by status
    List<Claims> findByStatus(String status);
}
