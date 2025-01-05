package com.has.core_backend.echostream.models.shared.enums;

import lombok.Getter;

@Getter
public enum DeviceStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    ERROR("Error");

    private final String name;

    DeviceStatus(String name) {
        this.name = name;
    }
}
