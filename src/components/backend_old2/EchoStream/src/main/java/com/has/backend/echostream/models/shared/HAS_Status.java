package com.has.backend.echostream.models.shared;


import com.has.backend.echostream.models.shared.enums.StatusEnum;
import com.sun.jna.platform.win32.Sspi;

import java.time.LocalDateTime;

public interface HAS_Status {

    StatusEnum value = StatusEnum.CREATED;
    LocalDateTime getLastChange = LocalDateTime.now();
    StatusEnum getLastValue = StatusEnum.INTIALIZED;

}

