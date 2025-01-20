package com.lic.backend.repository;

import com.lic.backend.model.PolicyRenewalReminders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PolicyRenewalReminderRepository extends JpaRepository<PolicyRenewalReminders, Long> {
    // Fetch reminders for a specific user policy
    List<PolicyRenewalReminders> findByUserPolicy_UserPolicyId(Long userPolicyId);

    // Fetch reminders by status
    List<PolicyRenewalReminders> findByStatus(String status);

    // Fetch reminders scheduled before a specific date
    List<PolicyRenewalReminders> findByReminderDateBefore(LocalDateTime date);
}
