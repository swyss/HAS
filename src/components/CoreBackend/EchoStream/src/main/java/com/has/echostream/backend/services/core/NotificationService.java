package com.has.echostream.backend.services.core;

import com.has.echostream.backend.models.core.HAS_Notification;
import com.has.echostream.backend.repos.core.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public HAS_Notification saveNotification(HAS_Notification notification) {
        return notificationRepository.save(notification);
    }

    public void markAsRead(Long id) {
        HAS_Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setRead(true);
        notificationRepository.save(notification);
    }

    public List<HAS_Notification> getCurrentTop100() {
        return notificationRepository.findAll().subList(0, Math.min(notificationRepository.findAll().size(), 100));

    }
}

