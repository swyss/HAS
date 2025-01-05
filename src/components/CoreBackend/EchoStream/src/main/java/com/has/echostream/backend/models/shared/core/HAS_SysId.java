package com.has.echostream.backend.models.shared.core;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class HAS_SysId {
    private final UUID sysId;

    public HAS_SysId() {
        this.sysId = UUID.randomUUID();
    }

}
