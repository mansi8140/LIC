package com.lic.backend.controller;

import com.lic.backend.DTO.PolicyRequestDTO;
import com.lic.backend.DTO.PolicyResponseDTO;
import com.lic.backend.model.Policy;
import com.lic.backend.repository.PolicyRepository;
import com.lic.backend.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



//@RestController
//@RequestMapping("/api/policies")
//public class PolicyController {
//
//    @Autowired
//    private PolicyService policyService;
//
//    @PostMapping
//    @PreAuthorize("hasRole('ROLE_AGENT')")
//    public ResponseEntity<PolicyResponseDTO> createPolicy(@RequestBody PolicyRequestDTO policyRequestDTO) {
//        PolicyResponseDTO createdPolicy = policyService.createPolicy(policyRequestDTO);
//        return new ResponseEntity<>(createdPolicy, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/my")
//    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
//    public ResponseEntity<List<PolicyResponseDTO>> getCustomerPolicies() {
//        // Implementation for customer viewing their own policies
//        PolicyResponseDTO getPolicy = policyService.getPolicy(po)
//        return  new ResponseEntity<>(createdPolicy, HttpStatus.CREATED);
//    }
//}




        import com.lic.backend.DTO.PolicyRequestDTO;
        import com.lic.backend.DTO.PolicyResponseDTO;
        import com.lic.backend.service.PolicyService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping
    public ResponseEntity<PolicyResponseDTO> createPolicy(@RequestBody PolicyRequestDTO policyRequestDTO) {
        PolicyResponseDTO createdPolicy = policyService.createPolicy(policyRequestDTO);
        return new ResponseEntity<>(createdPolicy, HttpStatus.CREATED);
    }

    @GetMapping("/my")
    public ResponseEntity<List<PolicyResponseDTO>> getMyPolicies() {
        List<PolicyResponseDTO> policies = policyService.getPoliciesForLoggedInCustomer();
        return ResponseEntity.ok(policies);
    }
}



