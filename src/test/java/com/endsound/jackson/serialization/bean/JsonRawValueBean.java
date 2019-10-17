package com.endsound.jackson.serialization.bean;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class JsonRawValueBean {
    @JsonRawValue
    private String json;

    public JsonRawValueBean(String json) {
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    public JsonRawValueBean setJson(String json) {
        this.json = json;
        return this;
    }
}
