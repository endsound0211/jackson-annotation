package com.endsound.jackson.inclusion.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "id" })
public class JsonIgnorePropertiesBean {
    private Integer id;
    private String name;

    public JsonIgnorePropertiesBean(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public JsonIgnorePropertiesBean setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public JsonIgnorePropertiesBean setName(String name) {
        this.name = name;
        return this;
    }
}
