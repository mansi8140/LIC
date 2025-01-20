package com.lic.backend.controller;

import com.lic.backend.model.Notifications;
import com.lic.backend.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    // Get all notifications
    @GetMapping
    public ResponseEntity<List<Notifications>> getAllNotifications() {
        return ResponseEntity.ok(notificationRepository.findAll());
    }

    // Get a notification by ID
    @GetMapping("/{id}")
    public ResponseEntity<Notifications> getNotificationById(@PathVariable Long id) {
        Optional<Notifications> notification = notificationRepository.findById(id);
        return notification.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get notifications for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notifications>> getNotificationsByUserId(@PathVariable Long userId) {
        List<Notifications> notifications = notificationRepository.findByUser_UserId(userId);
        return ResponseEntity.ok(notifications);
    }

    // Get unread notifications for a specific user
    @GetMapping("/user/{userId}/unread")
    public ResponseEntity<List<Notifications>> getUnreadNotificationsByUserId(@PathVariable Long userId) {
        List<Notifications> notifications = notificationRepository.findByUser_UserIdAndIsReadFalse(userId);
        return ResponseEntity.ok(notifications);
    }

    // Create a new notification
    @PostMapping
    public ResponseEntity<Notifications> createNotification(@RequestBody Notifications notification) {
        Notifications savedNotification = notificationRepository.save(notification);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNotification);
    }

    // Update a notification
    @PutMapping("/{id}")
    public ResponseEntity<Notifications> updateNotification(@PathVariable Long id, @RequestBody Notifications notificationDetails) {
        Optional<Notifications> optionalNotification = notificationRepository.findById(id);

        if (optionalNotification.isPresent()) {
            Notifications notification = optionalNotification.get();
            notification.setTitle(notificationDetails.getTitle());
            notification.setMessage(notificationDetails.getMessage());
            notification.setNotificationType(notificationDetails.getNotificationType());
            notification.setIsRead(notificationDetails.getIsRead());
            Notifications updatedNotification = notificationRepository.save(notification);
            return ResponseEntity.ok(updatedNotification);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a notification
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        if (notificationRepository.existsById(id)) {
            notificationRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
