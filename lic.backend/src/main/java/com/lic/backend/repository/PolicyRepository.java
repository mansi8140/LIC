package com.lic.backend.repository;

import com.lic.backend.model.Policies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policies, Long> {
    // Additional query methods, e.g., findByPolicyType
    List<Policies> findByPolicyType(String policyType);
}
