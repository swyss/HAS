package com.has.backend.echostream.models.shared;

import com.has.backend.echostream.models.shared.core.HAS_Status;
import com.has.backend.echostream.models.shared.core.HAS_SysId;
import com.has.backend.echostream.models.shared.core.HAS_Type;
import lombok.Getter;

@Getter
public abstract class BaseModel {
    private final HAS_SysId has_sysId;
    private final HAS_Status has_status;
    private final HAS_Type has_type;

    // Primary constructor
    public BaseModel(HAS_SysId sysId, HAS_Status status, HAS_Type type) {
        this.has_sysId = sysId;
        this.has_status = status;
        this.has_type = type;
    }

    // Overloaded constructor to auto-generate status using factory logic
    public BaseModel(HAS_SysId sysId, HAS_Type type) {
        this(sysId, StatusFactory.getStatusForType(type), type);
    }

    public BaseModel() {
        has_sysId = new HAS_SysId() {};
        has_status = StatusFactory.getStatusForType(new HAS_Type("defaultCoreType", "defaultSubType", "defaultDescription", "defaultUnit"));
        has_type = new HAS_Type("defaultCoreType", "defaultSubType", "defaultDescription", "defaultUnit");
    }
}