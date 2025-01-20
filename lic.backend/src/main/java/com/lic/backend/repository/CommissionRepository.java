package com.lic.backend.repository;

import com.lic.backend.model.Commissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CommissionRepository extends JpaRepository<Commissions, Long> {
    // Fetch commissions for a specific agent
    List<Commissions> findByAgent_UserId(Long agentId);

    // Fetch commissions for a specific policy
    List<Commissions> findByPolicy_PolicyId(Long policyId);

    // Fetch commissions generated within a date range
    List<Commissions> findByGeneratedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
}
