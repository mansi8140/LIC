package com.lic.backend.repository;

import com.lic.backend.model.Commissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommissionRepository extends JpaRepository<Commissions, Long> {

    List<Commissions> findByAgentId(Long agentId);
}
