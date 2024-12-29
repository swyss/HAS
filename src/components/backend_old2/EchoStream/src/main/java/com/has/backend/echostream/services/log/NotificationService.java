package com.has.backend.echostream.services.log;

import com.has.backend.echostream.models.core.HAS_Notification;
import com.has.backend.echostream.repos.core.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<HAS_Notification> getUnreadNotifications() {
        return notificationRepository.findByIsRead(false);
    }

    public HAS_Notification saveNotification(HAS_Notification notification) {
        return notificationRepository.save(notification);
    }

    public void markAsRead(Long id) {
        HAS_Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setIsRead(true);
        notificationRepository.save(notification);
    }
}

