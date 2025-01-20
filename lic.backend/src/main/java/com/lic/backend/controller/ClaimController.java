package com.lic.backend.controller;

import com.lic.backend.model.Claims;
import com.lic.backend.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimRepository claimRepository;

    // Get all claims
    @GetMapping
    public ResponseEntity<List<Claims>> getAllClaims() {
        return ResponseEntity.ok(claimRepository.findAll());
    }

    // Get claim by ID
    @GetMapping("/{id}")
    public ResponseEntity<Claims> getClaimById(@PathVariable Long id) {
        Optional<Claims> claim = claimRepository.findById(id);
        return claim.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get claims by User Policy ID
    @GetMapping("/user-policy/{userPolicyId}")
    public ResponseEntity<List<Claims>> getClaimsByUserPolicyId(@PathVariable Long userPolicyId) {
        List<Claims> claims = claimRepository.findByUserPolicy_UserPolicyId(userPolicyId);
        return ResponseEntity.ok(claims);
    }

    // Get claims by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Claims>> getClaimsByStatus(@PathVariable String status) {
        List<Claims> claims = claimRepository.findByStatus(status);
        return ResponseEntity.ok(claims);
    }

    // Create a new claim
    @PostMapping
    public ResponseEntity<Claims> createClaim(@RequestBody Claims claim) {
        Claims savedClaim = claimRepository.save(claim);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClaim);
    }

    // Update an existing claim
    @PutMapping("/{id}")
    public ResponseEntity<Claims> updateClaim(@PathVariable Long id, @RequestBody Claims claimDetails) {
        Optional<Claims> optionalClaim = claimRepository.findById(id);

        if (optionalClaim.isPresent()) {
            Claims claim = optionalClaim.get();
            claim.setUserPolicy(claimDetails.getUserPolicy());
            claim.setClaimDate(claimDetails.getClaimDate());
            claim.setStatus(claimDetails.getStatus());
            claim.setAmountClaimed(claimDetails.getAmountClaimed());
            claim.setAmountApproved(claimDetails.getAmountApproved());
            claim.setDescription(claimDetails.getDescription());
            Claims updatedClaim = claimRepository.save(claim);
            return ResponseEntity.ok(updatedClaim);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a claim
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        if (claimRepository.existsById(id)) {
            claimRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
