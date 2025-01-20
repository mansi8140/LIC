package com.lic.backend.controller;

import com.lic.backend.model.AuditLogs;
import com.lic.backend.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/audit-logs")
public class AuditLogController {

    @Autowired
    private AuditLogRepository auditLogRepository;

    // Get all audit logs
    @GetMapping
    public ResponseEntity<List<AuditLogs>> getAllAuditLogs() {
        return ResponseEntity.ok(auditLogRepository.findAll());
    }

    // Get an audit log by ID
    @GetMapping("/{id}")
    public ResponseEntity<AuditLogs> getAuditLogById(@PathVariable Long id) {
        Optional<AuditLogs> auditLog = auditLogRepository.findById(id);
        return auditLog.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get logs for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AuditLogs>> getLogsByUserId(@PathVariable Long userId) {
        List<AuditLogs> auditLogs = auditLogRepository.findByUser_UserId(userId);
        return ResponseEntity.ok(auditLogs);
    }

    // Get logs for a specific action
    @GetMapping("/action/{action}")
    public ResponseEntity<List<AuditLogs>> getLogsByAction(@PathVariable String action) {
        List<AuditLogs> auditLogs = auditLogRepository.findByAction(action);
        return ResponseEntity.ok(auditLogs);
    }

    // Get logs within a specific date range
    @GetMapping("/date-range")
    public ResponseEntity<List<AuditLogs>> getLogsByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        List<AuditLogs> auditLogs = auditLogRepository.findByTimestampBetween(start, end);
        return ResponseEntity.ok(auditLogs);
    }

    // Create a new audit log
    @PostMapping
    public ResponseEntity<AuditLogs> createAuditLog(@RequestBody AuditLogs auditLog) {
        AuditLogs savedAuditLog = auditLogRepository.save(auditLog);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAuditLog);
    }
}
