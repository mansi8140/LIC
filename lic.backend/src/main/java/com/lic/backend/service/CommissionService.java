package com.lic.backend.service;

import com.lic.backend.model.Commissions;
import com.lic.backend.repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommissionService {

    @Autowired
    private CommissionRepository commissionRepository;

    public List<Commissions> getMyCommissions() {
        Long agentId = 1L; // Dummy: Should fetch from logged-in user
        return commissionRepository.findByAgentId(agentId);
    }
}
