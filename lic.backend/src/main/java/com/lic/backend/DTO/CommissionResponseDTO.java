package com.lic.backend.DTO;

public class CommissionResponseDTO {

    private Long commissionId;
    private double commissionAmount;
    private String policyType;
    private String agentName;
    private String customerName;

    // Getters
    public Long getCommissionId() {
        return commissionId;
    }

    public double getCommissionAmount() {
        return commissionAmount;
    }

    public String getPolicyType() {
        return policyType;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getCustomerName(){
        return customerName;
    }

    // Setters
    public void setCommissionId(Long commissionId) {
        this.commissionId = commissionId;
    }

    public void setCommissionAmount(double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
}
