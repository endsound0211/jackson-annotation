package com.endsound.jackson.serialization.bean;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "id"})
public class JsonPropertyOrderBean {
    private Integer id;
    private String name;

    public JsonPropertyOrderBean(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public JsonPropertyOrderBean setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public JsonPropertyOrderBean setName(String name) {
        this.name = name;
        return this;
    }
}
