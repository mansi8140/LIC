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

}
