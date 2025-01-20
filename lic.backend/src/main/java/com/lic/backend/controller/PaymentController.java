package com.lic.backend.controller;

import com.lic.backend.model.Payments;
import com.lic.backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    // Get all payments
    @GetMapping
    public ResponseEntity<List<Payments>> getAllPayments() {
        return ResponseEntity.ok(paymentRepository.findAll());
    }

    // Get payment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Payments> getPaymentById(@PathVariable Long id) {
        Optional<Payments> payment = paymentRepository.findById(id);
        return payment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get payments by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Payments>> getPaymentsByUserId(@PathVariable Long userId) {
        List<Payments> payments = paymentRepository.findByUser_UserId(userId);
        return ResponseEntity.ok(payments);
    }

    // Get payments by User Policy ID
    @GetMapping("/user-policy/{userPolicyId}")
    public ResponseEntity<List<Payments>> getPaymentsByUserPolicyId(@PathVariable Long userPolicyId) {
        List<Payments> payments = paymentRepository.findByUserPolicy_UserPolicyId(userPolicyId);
        return ResponseEntity.ok(payments);
    }

    // Get payment by Transaction ID
    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<Payments> getPaymentByTransactionId(@PathVariable String transactionId) {
        Payments payment = paymentRepository.findByTransactionId(transactionId);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Create a new payment
    @PostMapping
    public ResponseEntity<Payments> createPayment(@RequestBody Payments payment) {
        Payments savedPayment = paymentRepository.save(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPayment);
    }

    // Update a payment
    @PutMapping("/{id}")
    public ResponseEntity<Payments> updatePayment(@PathVariable Long id, @RequestBody Payments paymentDetails) {
        Optional<Payments> optionalPayment = paymentRepository.findById(id);

        if (optionalPayment.isPresent()) {
            Payments payment = optionalPayment.get();
            payment.setAmount(paymentDetails.getAmount());
            payment.setPaymentDate(paymentDetails.getPaymentDate());
            payment.setPaymentMethod(paymentDetails.getPaymentMethod());
            payment.setStatus(paymentDetails.getStatus());
            payment.setTransactionId(paymentDetails.getTransactionId());
            payment.setGateway(paymentDetails.getGateway());
            payment.setCurrency(paymentDetails.getCurrency());
            payment.setNotes(paymentDetails.getNotes());
            Payments updatedPayment = paymentRepository.save(payment);
            return ResponseEntity.ok(updatedPayment);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a payment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
