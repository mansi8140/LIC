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


    // Getters and Setters

    public Long getId() {
        return id;
    }

    public double getCommissionAmount() {
        return commissionAmount;
    }

    public Policy getPolicy() {
        return policy;
    }

    public User getAgent() {
        return agent;
    }


    public void setCommissionAmount(double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public void setAgent(User agent) {
        this.agent = agent;
    }

}
