package com.has.core_backend.echostream.models.shared.core;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class HAS_Status {
    // Status properties
    private final String currentStatus;
    private final String previousStatus;
    private final LocalDateTime timeStamp;

    // Optional Description with default value
    private static final String DEFAULT_DESCRIPTION = "No description provided";
    private final String description;

    // Constructor
    public HAS_Status(String currentStatus, String previousStatus, LocalDateTime timeStamp, String description) {
        this.currentStatus = currentStatus;
        this.previousStatus = previousStatus;
        this.timeStamp = timeStamp;
        this.description = description == null || description.isBlank() ? DEFAULT_DESCRIPTION : description;
    }
}