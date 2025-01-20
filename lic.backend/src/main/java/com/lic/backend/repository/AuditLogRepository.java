package com.lic.backend.repository;

import com.lic.backend.model.AuditLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLogs, Long> {
    // Fetch logs for a specific user
    List<AuditLogs> findByUser_UserId(Long userId);

    // Fetch logs for a specific action
    List<AuditLogs> findByAction(String action);

    // Fetch logs within a date range
    List<AuditLogs> findByTimestampBetween(LocalDateTime startDate, LocalDateTime endDate);
}
