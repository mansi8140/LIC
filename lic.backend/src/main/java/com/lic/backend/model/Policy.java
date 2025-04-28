package com.lic.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyType;
    private double premiumAmount;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private User agent;

    @OneToOne(mappedBy = "policy", cascade = CascadeType.ALL)
    private Commissions commission;

    // Setters
    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public void setAgent(User agent) {
        this.agent = agent;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public User getAgent() {
        return agent;
    }

    public User getCustomer() {
        return customer;
    }
}
