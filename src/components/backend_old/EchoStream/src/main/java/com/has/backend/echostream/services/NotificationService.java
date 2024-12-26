package com.has.backend.echostream.services;

import com.has.backend.echostream.models.Notification;
import com.has.backend.echostream.repos.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public List<Notification> findAll() {
        return repository.findAll();
    }

    public Notification save(Notification notification) {
        return repository.save(notification);
    }

    public List<Notification> findUnread() {
        return repository.findByIsReadFalse();
    }

    public void markAsRead(Long id) {
        Notification notification = repository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setIsRead(true);
        repository.save(notification);
    }
}
