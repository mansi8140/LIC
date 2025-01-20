package com.lic.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
public class AuditLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user; // Reference to User entity (can be null for system actions)

    @Column(nullable = false, length = 100)
    private String action; // Action performed (e.g., "User Login", "Policy Created")

    @Column(nullable = false, length = 255)
    private String details; // Additional details about the action

    @Column(nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now(); // When the action occurred

    // Getters and Setters

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
