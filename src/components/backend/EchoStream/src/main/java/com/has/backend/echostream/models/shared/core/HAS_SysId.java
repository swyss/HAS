package com.has.backend.echostream.models.shared.core;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class HAS_SysId {
    private final UUID sysid;

    public HAS_SysId() {
        this.sysid = UUID.randomUUID();
    }

}
