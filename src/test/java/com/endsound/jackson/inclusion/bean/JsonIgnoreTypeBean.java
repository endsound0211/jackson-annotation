package com.endsound.jackson.inclusion.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

public class JsonIgnoreTypeBean {
    private Integer id;
    private Name name;

    @JsonIgnoreType
    public static class Name{
        private String firstName;
        private String secondName;

        public Name(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }
    }

    public JsonIgnoreTypeBean(Integer id, Name name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public JsonIgnoreTypeBean setId(Integer id) {
        this.id = id;
        return this;
    }

    public Name getName() {
        return name;
    }

    public JsonIgnoreTypeBean setName(Name name) {
        this.name = name;
        return this;
    }
}
