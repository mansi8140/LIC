package com.lic.backend.DTO;

import java.time.LocalDate;

public class PolicyRequestDTO {

    private Long customerId;
    private String policyType;
    private double premiumAmount;
    private LocalDate startDate;
    private LocalDate endDate;

    // Getters
    public Long getCustomerId() {
        return customerId;
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

    // Setters
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
}
