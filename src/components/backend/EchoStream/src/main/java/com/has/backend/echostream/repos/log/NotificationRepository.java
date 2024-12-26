package com.has.backend.echostream.repos.log;

import com.has.backend.echostream.models.log.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByIsRead(Boolean isRead);
    List<Notification> findByType(String type);
}

