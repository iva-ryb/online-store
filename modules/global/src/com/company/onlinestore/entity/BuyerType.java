package com.company.onlinestore.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum BuyerType implements EnumClass<String> {

    PRIVATE("private"),
    LEGAL("legal");

    private String id;

    BuyerType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static BuyerType fromId(String id) {
        for (BuyerType at : BuyerType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}