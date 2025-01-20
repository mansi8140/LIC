package com.lic.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "claims")
public class Claims {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "user_policy_id", nullable = false)
    private UserPolicies userPolicy; // Reference to UserPolicies entity

    @Column(nullable = false)
    private LocalDateTime claimDate; // Date when the claim was filed

    @Column(nullable = false, length = 20)
    private String status; // Status of the claim (e.g., Pending, Approved, Rejected)

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amountClaimed; // Amount claimed by the user

    @Column(precision = 10, scale = 2)
    private BigDecimal amountApproved; // Amount approved for the claim

    @Column(length = 255)
    private String description; // Details about the claim

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // Creation timestamp

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now(); // Last updated timestamp

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public UserPolicies getUserPolicy() {
        return userPolicy;
    }

    public void setUserPolicy(UserPolicies userPolicy) {
        this.userPolicy = userPolicy;
    }

    public LocalDateTime getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDateTime claimDate) {
        this.claimDate = claimDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmountClaimed() {
        return amountClaimed;
    }

    public void setAmountClaimed(BigDecimal amountClaimed) {
        this.amountClaimed = amountClaimed;
    }

    public BigDecimal getAmountApproved() {
        return amountApproved;
    }

    public void setAmountApproved(BigDecimal amountApproved) {
        this.amountApproved = amountApproved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
