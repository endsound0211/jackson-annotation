package com.endsound.jackson.inclusion.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JsonIgnoreBean {
    @JsonIgnore
    private Integer id;
    private String name;

    public JsonIgnoreBean(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public JsonIgnoreBean setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public JsonIgnoreBean setName(String name) {
        this.name = name;
        return this;
    }
}
