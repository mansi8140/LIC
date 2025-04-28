package com.lic.backend.service;
import com.lic.backend.DTO.PolicyRequestDTO;
import com.lic.backend.DTO.PolicyResponseDTO;
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


    public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {
        User customer = userRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Assume the logged-in user is the agent
        User agent = getLoggedInUser(); // Fetch from SecurityContextHolder

        Policy policy = new Policy();
        policy.setCustomer(customer);
        policy.setAgent(agent);
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());

        Policy savedPolicy = policyRepository.save(policy);

        // Convert to Response DTO
        PolicyResponseDTO responseDTO = new PolicyResponseDTO();
        responseDTO.setPolicyId(savedPolicy.getId());
        responseDTO.setPolicyType(savedPolicy.getPolicyType());
        responseDTO.setPremiumAmount(savedPolicy.getPremiumAmount());
        responseDTO.setStartDate(savedPolicy.getStartDate());
        responseDTO.setEndDate(savedPolicy.getEndDate());
        responseDTO.setAgentName(agent.getFullName());
        responseDTO.setCustomerName(customer.getFullName());

        return responseDTO;
    }
    public Policy getPolicy(PolicyRequestDTO dto) {
        User customer = userRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Long user_id = dto.getCustomerId();

        Policy savedPolicy = policyRepository.getReferenceById(user_id);

        return savedPolicy;
    }

}



