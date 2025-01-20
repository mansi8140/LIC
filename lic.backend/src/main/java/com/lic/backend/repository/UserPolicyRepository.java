package com.lic.backend.repository;

import com.lic.backend.model.UserPolicies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPolicyRepository extends JpaRepository<UserPolicies, Long> {
    // Fetch all policies for a specific user
    List<UserPolicies> findByUser_UserId(Long userId);

    // Fetch all users for a specific policy
    List<UserPolicies> findByPolicy_PolicyId(Long policyId);

    // Fetch active policies for a user
    List<UserPolicies> findByUser_UserIdAndIsActive(Long userId, Boolean isActive);
}
