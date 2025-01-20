package com.lic.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Reference to User entity

    @Column(nullable = false, length = 100)
    private String subject; // Subject or title of the ticket

    @Column(nullable = false, length = 500)
    private String description; // Detailed description of the issue

    @Column(nullable = false, length = 20)
    private String status = "Open"; // Status of the ticket (e.g., Open, In Progress, Resolved)

    @Column(nullable = false, length = 10)
    private String priority = "Medium"; // Priority of the ticket (e.g., Low, Medium, High)

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // Ticket creation timestamp

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now(); // Last updated timestamp

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
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
