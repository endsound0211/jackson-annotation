package com.endsound.jackson.serialization.bean;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeEnum {
    TYPE1(1, "Type A"), TYPE2(2, "Type 2");

    private Integer id;
    private String name;

    TypeEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
