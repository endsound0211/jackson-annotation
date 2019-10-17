package com.endsound.jackson.deserialization.bean;

import com.fasterxml.jackson.annotation.JsonSetter;

public class JsonSetterBean {
    @JsonSetter("theName")
    private String name;

    public String getName() {
        return name;
    }

    public JsonSetterBean setName(String name) {
        this.name = name;
        return this;
    }
}
