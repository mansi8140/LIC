package com.lic.backend.model;

import com.lic.backend.model.UserPolicies;
import com.lic.backend.model.User;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Reference to User entity

    @ManyToOne
    @JoinColumn(name = "user_policy_id", nullable = false)
    private UserPolicies userPolicy; // Reference to UserPolicies entity

    @Column(nullable = false)
    private LocalDateTime paymentDate; // Payment date and time

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount; // Amount paid

    @Column(length = 50)
    private String paymentMethod; // Payment method (e.g., Credit Card, UPI)

    @Column(length = 20, nullable = false)
    private String status; // Payment status (e.g., Successful, Failed)

    @Column(length = 100, unique = true)
    private String transactionId; // Transaction ID from the payment gateway

    @Column(length = 50)
    private String gateway; // Payment gateway used

    @Column(length = 10, nullable = false)
    private String currency = "INR"; // Currency used

    @Column(length = 255)
    private String notes; // Optional notes for the payment

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // Record creation timestamp

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now(); // Record last updated timestamp

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserPolicies getUserPolicy() {
        return userPolicy;
    }

    public void setUserPolicy(UserPolicies userPolicy) {
        this.userPolicy = userPolicy;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
