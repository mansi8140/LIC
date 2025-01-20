package com.lic.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "policy_comparisons")
public class PolicyComparisons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comparisonId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user; // Reference to User entity (Nullable for guest comparisons)

    @Column(nullable = false, length = 500)
    private String policyIds; // Comma-separated list of policy IDs being compared

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // Record creation timestamp

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now(); // Record last updated timestamp

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getComparisonId() {
        return comparisonId;
    }

    public void setComparisonId(Long comparisonId) {
        this.comparisonId = comparisonId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPolicyIds() {
        return policyIds;
    }

    public void setPolicyIds(String policyIds) {
        this.policyIds = policyIds;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
