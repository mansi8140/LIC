package com.lic.backend.service;

import com.lic.backend.DTO.PolicyRequestDTO;
import com.lic.backend.DTO.PolicyResponseDTO;
import com.lic.backend.model.Commissions;
import com.lic.backend.model.Policy;
import com.lic.backend.model.User;
import com.lic.backend.repository.CommissionRepository;
import com.lic.backend.repository.PolicyRepository;
import com.lic.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommissionRepository commissionRepository;

    public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {
        User customer = userRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Dummy agent for now - should get from logged-in user in real system
        Long agentId = 1L;
        User agent = userRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found"));

        Policy policy = new Policy();
        policy.setCustomer(customer);
        policy.setAgent(agent);
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());

        Policy savedPolicy = policyRepository.save(policy);

        // Now create Commission
        double commissionRate = 0.05; // 5% commission
        double commissionAmount = savedPolicy.getPremiumAmount() * commissionRate;

        Commissions commission = new Commissions();
        commission.setPolicy(savedPolicy);
        commission.setAgent(agent);
        commission.setCommissionAmount(commissionAmount);

        commissionRepository.save(commission);

        // Build Response DTO correctly
        PolicyResponseDTO responseDTO = new PolicyResponseDTO();
        responseDTO.setPolicyId(savedPolicy.getId());  // Long
        responseDTO.setPolicyType(savedPolicy.getPolicyType()); // String
        responseDTO.setPremiumAmount(savedPolicy.getPremiumAmount()); // double
        responseDTO.setStartDate(savedPolicy.getStartDate()); // LocalDate
        responseDTO.setEndDate(savedPolicy.getEndDate()); // LocalDate
        responseDTO.setAgentName(agent.getFullName()); // String
        responseDTO.setCustomerName(customer.getFullName()); // String

        return responseDTO;
    }

    public List<PolicyResponseDTO> getPoliciesForLoggedInCustomer() {
        Long customerId = 2L; // Dummy customerId (later dynamically)
        List<Policy> policies = policyRepository.findByCustomerId(customerId);

        return policies.stream().map(policy -> {
            PolicyResponseDTO dto = new PolicyResponseDTO();
            dto.setPolicyId(policy.getId());
            dto.setPolicyType(policy.getPolicyType());
            dto.setPremiumAmount(policy.getPremiumAmount());
            dto.setStartDate(policy.getStartDate());
            dto.setEndDate(policy.getEndDate());
            dto.setAgentName(policy.getAgent().getFullName());
            dto.setCustomerName(policy.getCustomer().getFullName());
            return dto;
        }).collect(Collectors.toList());
    }
}
