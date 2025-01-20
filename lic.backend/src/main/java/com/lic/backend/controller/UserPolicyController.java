package com.lic.backend.controller;

import com.lic.backend.model.UserPolicies;
import com.lic.backend.repository.UserPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user-policies")
public class UserPolicyController {

    @Autowired
    private UserPolicyRepository userPolicyRepository;

    // Get all user policies
    @GetMapping
    public ResponseEntity<List<UserPolicies>> getAllUserPolicies() {
        return ResponseEntity.ok(userPolicyRepository.findAll());
    }

    // Get a user policy by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserPolicies> getUserPolicyById(@PathVariable Long id) {
        Optional<UserPolicies> userPolicy = userPolicyRepository.findById(id);
        return userPolicy.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get all policies for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserPolicies>> getPoliciesByUserId(@PathVariable Long userId) {
        List<UserPolicies> userPolicies = userPolicyRepository.findByUser_UserId(userId);
        return ResponseEntity.ok(userPolicies);
    }

    // Get all users for a specific policy
    @GetMapping("/policy/{policyId}")
    public ResponseEntity<List<UserPolicies>> getUsersByPolicyId(@PathVariable Long policyId) {
        List<UserPolicies> userPolicies = userPolicyRepository.findByPolicy_PolicyId(policyId);
        return ResponseEntity.ok(userPolicies);
    }

    // Get active policies for a specific user
    @GetMapping("/user/{userId}/active")
    public ResponseEntity<List<UserPolicies>> getActivePoliciesByUserId(@PathVariable Long userId) {
        List<UserPolicies> userPolicies = userPolicyRepository.findByUser_UserIdAndIsActive(userId, true);
        return ResponseEntity.ok(userPolicies);
    }

    // Create a new user policy
    @PostMapping
    public ResponseEntity<UserPolicies> createUserPolicy(@RequestBody UserPolicies userPolicy) {
        UserPolicies savedUserPolicy = userPolicyRepository.save(userPolicy);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserPolicy);
    }

    // Update a user policy
    @PutMapping("/{id}")
    public ResponseEntity<UserPolicies> updateUserPolicy(@PathVariable Long id, @RequestBody UserPolicies userPolicyDetails) {
        Optional<UserPolicies> optionalUserPolicy = userPolicyRepository.findById(id);

        if (optionalUserPolicy.isPresent()) {
            UserPolicies userPolicy = optionalUserPolicy.get();
            userPolicy.setUser(userPolicyDetails.getUser());
            userPolicy.setPolicy(userPolicyDetails.getPolicy());
            userPolicy.setIsActive(userPolicyDetails.getIsActive());
            userPolicy.setStartDate(userPolicyDetails.getStartDate());
            userPolicy.setEndDate(userPolicyDetails.getEndDate());
            UserPolicies updatedUserPolicy = userPolicyRepository.save(userPolicy);
            return ResponseEntity.ok(updatedUserPolicy);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a user policy
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserPolicy(@PathVariable Long id) {
        if (userPolicyRepository.existsById(id)) {
            userPolicyRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
