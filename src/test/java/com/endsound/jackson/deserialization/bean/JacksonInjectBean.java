package com.endsound.jackson.deserialization.bean;

import com.fasterxml.jackson.annotation.JacksonInject;

public class JacksonInjectBean {
    @JacksonInject
    public Integer id;
    public String name;

    public Integer getId() {
        return id;
    }

    public JacksonInjectBean setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public JacksonInjectBean setName(String name) {
        this.name = name;
        return this;
    }
}
