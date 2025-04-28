package com.lic.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "commissions")
public class Commissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double commissionAmount;

    @OneToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private User agent;

    public void setPolicy(Policy savedPolicy) {
    }

    public void setAgent(User agent) {
    }

    public void setCommissionAmount(double commissionAmount) {
    }

    // Getters and Setters
}
