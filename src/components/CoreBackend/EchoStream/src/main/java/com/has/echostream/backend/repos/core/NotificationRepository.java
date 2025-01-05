package com.has.core_backend.echostream.repos.core;

import com.has.core_backend.echostream.models.core.HAS_Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<HAS_Notification, Long> {
    List<HAS_Notification> findByType(String type);
}

