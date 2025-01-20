package com.lic.backend.controller;

import com.lic.backend.model.Commissions;
import com.lic.backend.repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commissions")
public class CommissionController {

    @Autowired
    private CommissionRepository commissionRepository;

    // Get all commissions
    @GetMapping
    public ResponseEntity<List<Commissions>> getAllCommissions() {
        return ResponseEntity.ok(commissionRepository.findAll());
    }

    // Get a commission by ID
    @GetMapping("/{id}")
    public ResponseEntity<Commissions> getCommissionById(@PathVariable Long id) {
        Optional<Commissions> commission = commissionRepository.findById(id);
        return commission.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get commissions for a specific agent
    @GetMapping("/agent/{agentId}")
    public ResponseEntity<List<Commissions>> getCommissionsByAgentId(@PathVariable Long agentId) {
        List<Commissions> commissions = commissionRepository.findByAgent_UserId(agentId);
        return ResponseEntity.ok(commissions);
    }

    // Get commissions for a specific policy
    @GetMapping("/policy/{policyId}")
    public ResponseEntity<List<Commissions>> getCommissionsByPolicyId(@PathVariable Long policyId) {
        List<Commissions> commissions = commissionRepository.findByPolicy_PolicyId(policyId);
        return ResponseEntity.ok(commissions);
    }

    // Get commissions generated within a date range
    @GetMapping("/generated-between")
    public ResponseEntity<List<Commissions>> getCommissionsByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        List<Commissions> commissions = commissionRepository.findByGeneratedAtBetween(start, end);
        return ResponseEntity.ok(commissions);
    }

    // Create a new commission
    @PostMapping
    public ResponseEntity<Commissions> createCommission(@RequestBody Commissions commission) {
        Commissions savedCommission = commissionRepository.save(commission);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCommission);
    }

    // Update a commission
    @PutMapping("/{id}")
    public ResponseEntity<Commissions> updateCommission(@PathVariable Long id, @RequestBody Commissions commissionDetails) {
        Optional<Commissions> optionalCommission = commissionRepository.findById(id);

        if (optionalCommission.isPresent()) {
            Commissions commission = optionalCommission.get();
            commission.setAgent(commissionDetails.getAgent());
            commission.setUser(commissionDetails.getUser());
            commission.setPolicy(commissionDetails.getPolicy());
            commission.setCommissionPercentage(commissionDetails.getCommissionPercentage());
            commission.setCommissionAmount(commissionDetails.getCommissionAmount());
            commission.setGeneratedAt(commissionDetails.getGeneratedAt());
            Commissions updatedCommission = commissionRepository.save(commission);
            return ResponseEntity.ok(updatedCommission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a commission
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommission(@PathVariable Long id) {
        if (commissionRepository.existsById(id)) {
            commissionRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
