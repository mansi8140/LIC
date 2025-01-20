package com.lic.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "policy_renewal_reminders")
public class PolicyRenewalReminders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reminderId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "user_policy_id", nullable = false)
    private UserPolicies userPolicy; // Reference to UserPolicies entity

    @Column(nullable = false)
    private LocalDateTime reminderDate; // Date of the reminder

    @Column(nullable = false)
    private LocalDateTime policyDueDate; // The due date for the policy renewal

    @Column(nullable = false, length = 20)
    private String status = "Pending"; // Status of the reminder (e.g., Pending, Sent, Expired)

    @Column(length = 255)
    private String additionalNotes; // Optional field for any additional notes

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // Record creation timestamp

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now(); // Record last updated timestamp

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getReminderId() {
        return reminderId;
    }

    public void setReminderId(Long reminderId) {
        this.reminderId = reminderId;
    }

    public UserPolicies getUserPolicy() {
        return userPolicy;
    }

    public void setUserPolicy(UserPolicies userPolicy) {
        this.userPolicy = userPolicy;
    }

    public LocalDateTime getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(LocalDateTime reminderDate) {
        this.reminderDate = reminderDate;
    }

    public LocalDateTime getPolicyDueDate() {
        return policyDueDate;
    }

    public void setPolicyDueDate(LocalDateTime policyDueDate) {
        this.policyDueDate = policyDueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
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
