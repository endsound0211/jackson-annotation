package com.endsound.jackson.serialization.bean;

import com.fasterxml.jackson.annotation.JsonGetter;

public class JsonGetterBean {
    private String name;

    @JsonGetter("TheName")
    public String getName() {
        return name;
    }

    public JsonGetterBean setName(String name) {
        this.name = name;
        return this;
    }
}
