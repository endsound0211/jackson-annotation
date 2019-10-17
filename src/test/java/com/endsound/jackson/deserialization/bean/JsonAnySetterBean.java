package com.endsound.jackson.deserialization.bean;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class JsonAnySetterBean {
    private String name;
    @JsonAnySetter
    private Map<String, String> properties = new HashMap<>();

    public String getName() {
        return name;
    }

    public JsonAnySetterBean setName(String name) {
        this.name = name;
        return this;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public JsonAnySetterBean setProperties(Map<String, String> properties) {
        this.properties = properties;
        return this;
    }
}
