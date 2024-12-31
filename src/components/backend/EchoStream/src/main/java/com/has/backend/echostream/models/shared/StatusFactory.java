package com.has.backend.echostream.models.shared;

import com.has.backend.echostream.models.shared.core.HAS_Status;
import com.has.backend.echostream.models.shared.core.HAS_Type;

import java.time.LocalDateTime;

public class StatusFactory {

    public static HAS_Status getStatusForType(HAS_Type has_type) {
        return new HAS_Status(has_type.getCoretype(), has_type.getSubtype(), LocalDateTime.now(), has_type.getDescription());
    }
}
