package com.has.backend.echostream.repos.core;

import com.has.backend.echostream.models.core.HAS_Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<HAS_Notification, Long> {
    List<HAS_Notification> findByType(String type);
}

