package com.has.core_backend.echostream.models.shared.enums;

public enum DeviceType {
    SENSOR("Sensor"),
    ACTUATOR("Actuator"),
    CONTROLLER("Controller");

    private final String typeName;

    DeviceType(String typeName) {
        this.typeName = typeName;
    }

}
