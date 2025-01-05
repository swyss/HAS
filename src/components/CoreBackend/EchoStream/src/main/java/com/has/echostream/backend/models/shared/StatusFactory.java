package com.has.echostream.backend.models.shared;

import com.has.echostream.backend.models.shared.core.HAS_Status;
import com.has.echostream.backend.models.shared.core.HAS_Type;

import java.time.LocalDateTime;

public class StatusFactory {

    public static HAS_Status getDefaultStatus(){
        return new HAS_Status("defaultStatus", "none", LocalDateTime.now(), null);
    }

    public static HAS_Status getStatusForType(HAS_Type hasType) {
        return new HAS_Status("defaultStatus", "none", LocalDateTime.now(), null);
    }
}
