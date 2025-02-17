package com.has.echostream.backend.models.shared.enums;

import lombok.Getter;

@Getter
public enum DataPointType {
    TEMPERATURE("Temperature Sensor"),
    HUMIDITY("Humidity Sensor"),
    PRESSURE("Pressure Sensor");

    private final String description;

    DataPointType(String description) {
        this.description = description;
    }

}
