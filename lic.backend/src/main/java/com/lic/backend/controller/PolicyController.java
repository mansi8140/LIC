package com.lic.backend.controller;

import com.lic.backend.model.Policies;
import com.lic.backend.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    @Autowired
    private PolicyRepository policyRepository;

    // Get all policies
    @GetMapping
    public ResponseEntity<List<Policies>> getAllPolicies() {
        return ResponseEntity.ok(policyRepository.findAll());
    }

    // Get a policy by ID
    @GetMapping("/{id}")
    public ResponseEntity<Policies> getPolicyById(@PathVariable Long id) {
        Optional<Policies> policy = policyRepository.findById(id);
        return policy.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new policy
    @PostMapping
    public ResponseEntity<Policies> createPolicy(@RequestBody Policies policy) {
        Policies savedPolicy = policyRepository.save(policy);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPolicy);
    }

    // Update a policy
    @PutMapping("/{id}")
    public ResponseEntity<Policies> updatePolicy(@PathVariable Long id, @RequestBody Policies policyDetails) {
        Optional<Policies> optionalPolicy = policyRepository.findById(id);

        if (optionalPolicy.isPresent()) {
            Policies policy = optionalPolicy.get();
            policy.setPolicyName(policyDetails.getPolicyName());
            policy.setSumAssured(policyDetails.getSumAssured());
            policy.setPremiumAmount(policyDetails.getPremiumAmount());
            policy.setDurationInYears(policyDetails.getDurationInYears()); // Use durationInYears instead
            Policies updatedPolicy = policyRepository.save(policy);
            return ResponseEntity.ok(updatedPolicy);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a policy
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        if (policyRepository.existsById(id)) {
            policyRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
