package com.has.echostream.backend.models.shared;

import com.has.echostream.backend.models.shared.core.HAS_Type;

public class TypeFactory {

    public static HAS_Type getDefaultType() {
        return new HAS_Type("defaultCoreType", "defaultSubType", "defaultDescription", "defaultUnit");
    }
}
