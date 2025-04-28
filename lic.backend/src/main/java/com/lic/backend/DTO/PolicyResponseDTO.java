package com.lic.backend.DTO;

import java.time.LocalDate;

public class PolicyResponseDTO {

    private Long policyId;
    private String policyType;
    private double premiumAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String agentName;
    private String customerName;

    // Setters
    public void setPolicyId(Long id) {
        this.policyId = id;
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

    public void setAgentName(String fullName) {
        this.agentName = fullName;
    }

    public void setCustomerName(String fullName) {
        this.customerName = fullName;
    }

    // Getters
    public Long getPolicyId() {
        return policyId;
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

    public String getAgentName() {
        return agentName;
    }

    public String getCustomerName() {
        return customerName;
    }
}
