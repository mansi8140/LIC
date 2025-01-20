package com.lic.backend.repository;

import com.lic.backend.model.PaymentGatewayLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentGatewayLogRepository extends JpaRepository<PaymentGatewayLogs, Long> {
    // Fetch logs for a specific payment
    List<PaymentGatewayLogs> findByPayment_PaymentId(Long paymentId);

    // Fetch logs by transaction ID
    List<PaymentGatewayLogs> findByTransactionId(String transactionId);

    // Fetch logs by response code
    List<PaymentGatewayLogs> findByResponseCode(String responseCode);
}
