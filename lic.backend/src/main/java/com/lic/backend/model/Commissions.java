package com.lic.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "commissions")
public class Commissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commissionId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    private User agent; // Reference to User entity (filtered for agents)

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Reference to the User entity (the client for whom the policy was taken)

    @ManyToOne
    @JoinColumn(name = "policy_id", nullable = false)
    private Policies policy; // Reference to Policies entity

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal commissionPercentage; // Percentage of commission

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal commissionAmount; // Calculated commission amount

    @Column(nullable = false)
    private LocalDateTime generatedAt; // Timestamp when the commission was generated

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // Record creation timestamp

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now(); // Record last updated timestamp

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(Long commissionId) {
        this.commissionId = commissionId;
    }

    public User getAgent() {
        return agent;
    }

    public void setAgent(User agent) {
        this.agent = agent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Policies getPolicy() {
        return policy;
    }

    public void setPolicy(Policies policy) {
        this.policy = policy;
    }

    public BigDecimal getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(BigDecimal commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public BigDecimal getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(BigDecimal commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
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
