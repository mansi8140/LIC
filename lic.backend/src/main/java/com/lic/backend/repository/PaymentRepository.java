package com.lic.backend.repository;

import com.lic.backend.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {
    // Fetch payments by user
    List<Payments> findByUser_UserId(Long userId);

    // Fetch payments by user policy
    List<Payments> findByUserPolicy_UserPolicyId(Long userPolicyId);

    // Fetch payments by transactionId
    Payments findByTransactionId(String transactionId);
}
