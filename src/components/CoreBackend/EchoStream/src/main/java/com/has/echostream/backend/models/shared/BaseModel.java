package com.has.echostream.backend.models.shared;

import com.has.echostream.backend.models.shared.core.HAS_Status;
import com.has.echostream.backend.models.shared.core.HAS_SysId;
import com.has.echostream.backend.models.shared.core.HAS_Type;
import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class BaseModel {
    private final HAS_SysId has_sysId = new HAS_SysId() {
        @Override
        public UUID getSysId() {
            return super.getSysId();
        }
    };
    private final HAS_Status has_status;
    private final HAS_Type has_type;

    // Primary constructor
    public BaseModel(HAS_Status status, HAS_Type type) {
        this.has_status = status;
        this.has_type = type;
    }

    // Overloaded constructor to auto-generate status using factory logic
    public BaseModel(HAS_Type type) {
        has_status = StatusFactory.getDefaultStatus();
        this.has_type = type;
    }

    public BaseModel() {
        has_status = StatusFactory.getDefaultStatus();
        has_type = TypeFactory.getDefaultType();
    }
}