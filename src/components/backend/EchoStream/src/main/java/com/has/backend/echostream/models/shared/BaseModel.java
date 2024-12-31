package com.has.backend.echostream.models.shared;

import com.has.backend.echostream.models.shared.core.HAS_Status;
import com.has.backend.echostream.models.shared.core.HAS_SysId;
import com.has.backend.echostream.models.shared.core.HAS_Type;
import lombok.Getter;

@Getter
public abstract class BaseModel {
    private final HAS_SysId sysId;
    private final HAS_Status status;
    private final HAS_Type type;

    // Primary constructor
    public BaseModel(HAS_SysId sysId, HAS_Status status, HAS_Type type) {
        this.sysId = sysId;
        this.status = status;
        this.type = type;
    }

    // Overloaded constructor to auto-generate status using factory logic
    public BaseModel(HAS_SysId sysId, HAS_Type type) {
        this(sysId, StatusFactory.getStatusForType(type), type);
    }
}