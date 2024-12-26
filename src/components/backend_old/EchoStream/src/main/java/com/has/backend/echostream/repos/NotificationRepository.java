package com.has.backend.echostream.repos;

import com.has.backend.echostream.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByIsReadFalse();
    List<Notification> findByType(String type);
}
