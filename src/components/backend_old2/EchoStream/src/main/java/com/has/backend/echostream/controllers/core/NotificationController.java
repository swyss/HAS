package com.has.backend.echostream.controllers.core;

import com.has.backend.echostream.models.core.HAS_Notification;
import com.has.backend.echostream.services.log.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/unread")
    public List<HAS_Notification> getUnreadNotifications() {
        return notificationService.getUnreadNotifications();
    }

    @PostMapping
    public ResponseEntity<HAS_Notification> createNotification(@RequestBody HAS_Notification HASNotification) {
        HAS_Notification savedNotification = notificationService.saveNotification(HASNotification);
        return ResponseEntity.ok(savedNotification);
    }

    @PatchMapping("/{id}/mark-read")
    public ResponseEntity<Void> markNotificationAsRead(@PathVariable Long id) {
        notificationService.markAsRead(id);
        return ResponseEntity.noContent().build();
    }
}
