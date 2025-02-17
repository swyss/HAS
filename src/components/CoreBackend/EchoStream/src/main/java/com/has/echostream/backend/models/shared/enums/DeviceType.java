package com.has.echostream.backend.models.shared.enums;

public enum DeviceType {
    SENSOR("Sensor"),
    ACTUATOR("Actuator"),
    CONTROLLER("Controller");

    private final String typeName;

    DeviceType(String typeName) {
        this.typeName = typeName;
    }

}
