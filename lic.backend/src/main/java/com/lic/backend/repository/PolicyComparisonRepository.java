package com.lic.backend.repository;

import com.lic.backend.model.PolicyComparisons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyComparisonRepository extends JpaRepository<PolicyComparisons, Long> {
    // Fetch comparisons by user ID
    List<PolicyComparisons> findByUser_UserId(Long userId);
}
