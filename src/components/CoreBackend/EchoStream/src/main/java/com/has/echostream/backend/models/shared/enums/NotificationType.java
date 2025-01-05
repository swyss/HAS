package com.has.echostream.backend.models.shared.enums;

public enum NotificationType {
    MESSAGE("Message"),
    WARNING("Warning"),
    ALARM("Alarm"),
    ERROR("Error");

    private final String typeName;

    NotificationType(String typeName) {
        this.typeName = typeName;
    }

}
