package com.lic.backend.DTO;

import java.time.LocalDate;

public class PolicyRequestDTO {
    private Long customerId;
    private Long agentId;
    private String policyType;
    private double premiumAmount;
    private LocalDate startDate;
    private LocalDate endDate;

    public Object getPolicyType() {
        return this.policyType;
    }

    public Object getPremiumAmount() {
        return this.premiumAmount;
    }

    public Object getStartDate() {
        return this.startDate;
    }

    public Object getEndDate() {
        return this.endDate;
    }

    public Long getAgentId() {
        return this.agentId;
    }

    public Long getCustomerId() {
        return this.customerId;
    }
}
