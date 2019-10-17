package com.endsound.jackson.serialization.bean;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

public class JsonAnyGetterBean {
    public String name;
    private Map<String, String> properties;

    public String getName() {
        return name;
    }

    public JsonAnyGetterBean setName(String name) {
        this.name = name;
        return this;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public JsonAnyGetterBean setProperties(Map<String, String> properties) {
        this.properties = properties;
        return this;
    }
}
