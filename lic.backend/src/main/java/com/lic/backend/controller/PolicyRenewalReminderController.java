package com.lic.backend.controller;


import com.lic.backend.model.PolicyRenewalReminders;
import com.lic.backend.repository.PolicyRenewalReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/policy-renewal-reminders")
public class PolicyRenewalReminderController {

    @Autowired
    private PolicyRenewalReminderRepository reminderRepository;

    // Get all reminders
    @GetMapping
    public ResponseEntity<List<PolicyRenewalReminders>> getAllReminders() {
        return ResponseEntity.ok(reminderRepository.findAll());
    }

    // Get a reminder by ID
    @GetMapping("/{id}")
    public ResponseEntity<PolicyRenewalReminders> getReminderById(@PathVariable Long id) {
        Optional<PolicyRenewalReminders> reminder = reminderRepository.findById(id);
        return reminder.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get reminders for a specific user policy
    @GetMapping("/user-policy/{userPolicyId}")
    public ResponseEntity<List<PolicyRenewalReminders>> getRemindersByUserPolicyId(@PathVariable Long userPolicyId) {
        List<PolicyRenewalReminders> reminders = reminderRepository.findByUserPolicy_UserPolicyId(userPolicyId);
        return ResponseEntity.ok(reminders);
    }

    // Get reminders by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<PolicyRenewalReminders>> getRemindersByStatus(@PathVariable String status) {
        List<PolicyRenewalReminders> reminders = reminderRepository.findByStatus(status);
        return ResponseEntity.ok(reminders);
    }

    // Get reminders scheduled before a specific date
    @GetMapping("/before/{date}")
    public ResponseEntity<List<PolicyRenewalReminders>> getRemindersBeforeDate(@PathVariable String date) {
        LocalDateTime reminderDate = LocalDateTime.parse(date);
        List<PolicyRenewalReminders> reminders = reminderRepository.findByReminderDateBefore(reminderDate);
        return ResponseEntity.ok(reminders);
    }

    // Create a new reminder
    @PostMapping
    public ResponseEntity<PolicyRenewalReminders> createReminder(@RequestBody PolicyRenewalReminders reminder) {
        PolicyRenewalReminders savedReminder = reminderRepository.save(reminder);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReminder);
    }

    // Update an existing reminder
    @PutMapping("/{id}")
    public ResponseEntity<PolicyRenewalReminders> updateReminder(@PathVariable Long id, @RequestBody PolicyRenewalReminders reminderDetails) {
        Optional<PolicyRenewalReminders> optionalReminder = reminderRepository.findById(id);

        if (optionalReminder.isPresent()) {
            PolicyRenewalReminders reminder = optionalReminder.get();
            reminder.setUserPolicy(reminderDetails.getUserPolicy());
            reminder.setReminderDate(reminderDetails.getReminderDate());
            reminder.setPolicyDueDate(reminderDetails.getPolicyDueDate());
            reminder.setStatus(reminderDetails.getStatus());
            reminder.setAdditionalNotes(reminderDetails.getAdditionalNotes());
            PolicyRenewalReminders updatedReminder = reminderRepository.save(reminder);
            return ResponseEntity.ok(updatedReminder);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a reminder
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Long id) {
        if (reminderRepository.existsById(id)) {
            reminderRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

