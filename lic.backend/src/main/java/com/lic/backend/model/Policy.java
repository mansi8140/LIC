package com.lic.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "policies")




@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyType;
    private double premiumAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private User agent;

    private LocalDate startDate;
    private LocalDate endDate;

    public void setCustomer(User customer) {
    }

    public void setAgent(User agent) {
    }

    public void setPolicyType(Object policyType) {
    }

    public void setPremiumAmount(Object premiumAmount) {
    }

    public void setStartDate(Object startDate) {
    }

    public void setEndDate(Object endDate) {
    }

    // Getters, Setters, Constructors
}
