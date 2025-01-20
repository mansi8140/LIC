package com.lic.backend.model;

import com.lic.backend.model.Policies;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_policies")
public class UserPolicies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userPolicyId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Reference to User entity

    @ManyToOne
    @JoinColumn(name = "policy_id", nullable = false)
    private Policies policy; // Reference to Policies entity

    @Column(nullable = false)
    private Boolean isActive = true; // Indicates if the policy is active for the user

    @Column(nullable = false)
    private LocalDateTime startDate; // Policy start date for the user

    private LocalDateTime endDate; // Policy end date for the user (if applicable)

    // Getters and Setters

    public Long getUserPolicyId() {
        return userPolicyId;
    }

    public void setUserPolicyId(Long userPolicyId) {
        this.userPolicyId = userPolicyId;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
