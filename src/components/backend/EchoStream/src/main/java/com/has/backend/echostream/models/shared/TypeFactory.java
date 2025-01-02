package com.has.backend.echostream.models.shared;

import com.has.backend.echostream.models.shared.core.HAS_Type;

public class TypeFactory {

    public static HAS_Type getDefaultType() {
        return new HAS_Type("defaultCoreType", "defaultSubType", "defaultDescription", "defaultUnit");
    }
}
