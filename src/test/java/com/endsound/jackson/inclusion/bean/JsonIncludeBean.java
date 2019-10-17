package com.endsound.jackson.inclusion.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonIncludeBean {
    private Integer id;
    private String name;

    public JsonIncludeBean(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public JsonIncludeBean setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public JsonIncludeBean setName(String name) {
        this.name = name;
        return this;
    }
}
