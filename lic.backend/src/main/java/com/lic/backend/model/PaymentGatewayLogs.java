package com.lic.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment_gateway_logs")
public class PaymentGatewayLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gatewayLogId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payments payment; // Reference to Payments entity

    @Column(nullable = false, length = 100)
    private String transactionId; // Gateway transaction ID (matches Payments)

    @Column(nullable = false, length = 20)
    private String responseCode; // Response code from the payment gateway (e.g., "200", "FAILED")

    @Column(nullable = false, length = 500)
    private String responseMessage; // Full response message from the payment gateway

    @Column(nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now(); // When the log was recorded

    @Column(length = 255)
    private String additionalDetails; // Optional additional details

    // Getters and Setters

    public Long getGatewayLogId() {
        return gatewayLogId;
    }

    public void setGatewayLogId(Long gatewayLogId) {
        this.gatewayLogId = gatewayLogId;
    }

    public Payments getPayment() {
        return payment;
    }

    public void setPayment(Payments payment) {
        this.payment = payment;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }
}
