package com.lic.backend.service;
import com.lic.backend.DTO.PolicyRequestDTO;
import com.lic.backend.model.Policy;
import com.lic.backend.model.User;
import com.lic.backend.repository.PolicyRepository;
import com.lic.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private UserRepository userRepository;

    public Policy createPolicy(PolicyRequestDTO dto) {
        User customer = userRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        User agent = userRepository.findById(dto.getAgentId())
                .orElseThrow(() -> new RuntimeException("Agent not found"));

        Policy policy = new Policy();
        policy.setCustomer(customer);
        policy.setAgent(agent);
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());

        return policyRepository.save(policy);
    }
}



