package com.lic.backend.service;

import com.lic.backend.DTO.CommissionResponseDTO;
import com.lic.backend.model.Commissions;
import com.lic.backend.model.User;
import com.lic.backend.repository.CommissionRepository;
import com.lic.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommissionService {

    @Autowired
    private CommissionRepository commissionRepository;

    @Autowired
    private UserRepository userRepository;

    public List<CommissionResponseDTO> getMyCommissions(Long agent_id) {
        // Get logged-in agent
        String username = SecurityContextHolder.getContext().getAuthentication().getName() ;
        User agent = userRepository.getReferenceById(agent_id);

        List<Commissions> commissions = commissionRepository.findByAgentId(agent_id);

        // Map to DTOs
        return commissions.stream().map(commission -> {
            CommissionResponseDTO dto = new CommissionResponseDTO();
            dto.setCommissionId(commission.getId());
            dto.setCommissionAmount(commission.getCommissionAmount());
            dto.setPolicyType(commission.getPolicy().getPolicyType()); // From policy linked to commission
            dto.setAgentName(agent.getFullName());
            dto.setCustomerName(commission.getPolicy().getCustomer().getFullName());
            return dto;
        }).collect(Collectors.toList());
    }
}
