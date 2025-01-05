package com.has.echostream.backend.models.shared.enums;

import lombok.Getter;

@Getter
public enum ActuatorCommandType {
    START("Start command for the actuator"),
    STOP("Stop command for the actuator"),
    RESET("Reset command for the actuator");

    private final String description;

    ActuatorCommandType(String description) {
        this.description = description;
    }

}
