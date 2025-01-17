package com.lic.backend.controller;

import com.lic.backend.model.Policy;
import com.lic.backend.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyRepository policyRepository;

    // Get all policies
    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    // Get a policy by ID
    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable Long id) {
        return policyRepository.findById(id).orElseThrow(() -> new RuntimeException("Policy not found"));
    }

    // Add a new policy
    @PostMapping("/set")
    public Policy addPolicy(@RequestBody Policy policy) {
        return policyRepository.save(policy);
    }
}
