package com.lic.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "policies")
public class Policies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId; // Primary Key

    @Column(nullable = false, unique = true, length = 100)
    private String policyName; // Unique name of the policy

    @Column(length = 255)
    private String description; // Short description of the policy

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal premiumAmount; // Premium amount for the policy

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal sumAssured; // Sum assured for the policy

    @Column(nullable = false)
    private Integer durationInYears; // Duration of the policy in years

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // Creation timestamp

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now(); // Last update timestamp

    // Getters and Setters

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public BigDecimal getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(BigDecimal sumAssured) {
        this.sumAssured = sumAssured;
    }

    public Integer getDurationInYears() {
        return durationInYears;
    }

    public void setDurationInYears(Integer durationInYears) {
        this.durationInYears = durationInYears;
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

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
