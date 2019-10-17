package com.endsound.jackson.serialization.bean;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("RootName")
public class JsonRootNameBean {
    private String name;

    public JsonRootNameBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public JsonRootNameBean setName(String name) {
        this.name = name;
        return this;
    }
}
