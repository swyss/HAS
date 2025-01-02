package com.has.backend.echostream.models.shared.enums;

import lombok.Getter;

@Getter
public enum NotificationStatus {
    READ("Read"),
    UNREAD("Unread");

    private final String name;

    NotificationStatus(String name) {
        this.name = name;
    }

}