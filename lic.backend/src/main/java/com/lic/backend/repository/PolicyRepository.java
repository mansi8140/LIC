package com.lic.backend.repository;

import com.lic.backend.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    List<Policy> findByAgentId(Long agentId);
    List<Policy> findByCustomerId(Long customerId);
}

