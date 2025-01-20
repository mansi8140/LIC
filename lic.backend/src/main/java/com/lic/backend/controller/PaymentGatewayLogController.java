package com.lic.backend.controller;

import com.lic.backend.model.PaymentGatewayLogs;
import com.lic.backend.repository.PaymentGatewayLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment-gateway-logs")
public class PaymentGatewayLogController {

    @Autowired
    private PaymentGatewayLogRepository logRepository;

    // Get all payment gateway logs
    @GetMapping
    public ResponseEntity<List<PaymentGatewayLogs>> getAllLogs() {
        return ResponseEntity.ok(logRepository.findAll());
    }

    // Get a payment gateway log by ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentGatewayLogs> getLogById(@PathVariable Long id) {
        Optional<PaymentGatewayLogs> log = logRepository.findById(id);
        return log.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get logs for a specific payment
    @GetMapping("/payment/{paymentId}")
    public ResponseEntity<List<PaymentGatewayLogs>> getLogsByPaymentId(@PathVariable Long paymentId) {
        List<PaymentGatewayLogs> logs = logRepository.findByPayment_PaymentId(paymentId);
        return ResponseEntity.ok(logs);
    }

    // Get logs by transaction ID
    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<List<PaymentGatewayLogs>> getLogsByTransactionId(@PathVariable String transactionId) {
        List<PaymentGatewayLogs> logs = logRepository.findByTransactionId(transactionId);
        return ResponseEntity.ok(logs);
    }

    // Get logs by response code
    @GetMapping("/response-code/{responseCode}")
    public ResponseEntity<List<PaymentGatewayLogs>> getLogsByResponseCode(@PathVariable String responseCode) {
        List<PaymentGatewayLogs> logs = logRepository.findByResponseCode(responseCode);
        return ResponseEntity.ok(logs);
    }

    // Create a new payment gateway log
    @PostMapping
    public ResponseEntity<PaymentGatewayLogs> createLog(@RequestBody PaymentGatewayLogs log) {
        PaymentGatewayLogs savedLog = logRepository.save(log);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLog);
    }

    // Delete a payment gateway log
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        if (logRepository.existsById(id)) {
            logRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
