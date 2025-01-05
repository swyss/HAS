package com.has.echostream.backend.models.shared.core;

import lombok.Getter;

@Getter
public class HAS_Type {
    private final String coretype;
    private final String subtype;
    private final String description;
    private final String unit;

    public HAS_Type(String coretype, String subtype, String description, String unit) {
        this.coretype = coretype;
        this.subtype = subtype;
        this.description = description;
        this.unit = unit;
    }
}
