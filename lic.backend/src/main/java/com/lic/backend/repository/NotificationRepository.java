package com.lic.backend.repository;

import com.lic.backend.model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notifications, Long> {
    // Fetch notifications for a specific user
    List<Notifications> findByUser_UserId(Long userId);

    // Fetch unread notifications for a user
    List<Notifications> findByUser_UserIdAndIsReadFalse(Long userId);
}
