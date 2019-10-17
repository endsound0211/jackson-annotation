package com.endsound.jackson.deserialization.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonCreatorBean {
    private Integer id;
    private String name;

    @JsonCreator
    public JsonCreatorBean(
            @JsonProperty("id") Integer id,
            @JsonProperty("theName") String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
