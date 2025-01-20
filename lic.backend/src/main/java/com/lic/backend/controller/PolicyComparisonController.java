package com.lic.backend.controller;

import com.lic.backend.model.PolicyComparisons;
import com.lic.backend.repository.PolicyComparisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/policy-comparisons")
public class PolicyComparisonController {

    @Autowired
    private PolicyComparisonRepository comparisonRepository;

    // Get all policy comparisons
    @GetMapping
    public ResponseEntity<List<PolicyComparisons>> getAllComparisons() {
        return ResponseEntity.ok(comparisonRepository.findAll());
    }

    // Get a policy comparison by ID
    @GetMapping("/{id}")
    public ResponseEntity<PolicyComparisons> getComparisonById(@PathVariable Long id) {
        Optional<PolicyComparisons> comparison = comparisonRepository.findById(id);
        return comparison.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get policy comparisons by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PolicyComparisons>> getComparisonsByUserId(@PathVariable Long userId) {
        List<PolicyComparisons> comparisons = comparisonRepository.findByUser_UserId(userId);
        return ResponseEntity.ok(comparisons);
    }

    // Create a new policy comparison
    @PostMapping
    public ResponseEntity<PolicyComparisons> createComparison(@RequestBody PolicyComparisons comparison) {
        PolicyComparisons savedComparison = comparisonRepository.save(comparison);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComparison);
    }

    // Update an existing policy comparison
    @PutMapping("/{id}")
    public ResponseEntity<PolicyComparisons> updateComparison(@PathVariable Long id, @RequestBody PolicyComparisons comparisonDetails) {
        Optional<PolicyComparisons> optionalComparison = comparisonRepository.findById(id);

        if (optionalComparison.isPresent()) {
            PolicyComparisons comparison = optionalComparison.get();
            comparison.setUser(comparisonDetails.getUser());
            comparison.setPolicyIds(comparisonDetails.getPolicyIds());
            PolicyComparisons updatedComparison = comparisonRepository.save(comparison);
            return ResponseEntity.ok(updatedComparison);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a policy comparison
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComparison(@PathVariable Long id) {
        if (comparisonRepository.existsById(id)) {
            comparisonRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
