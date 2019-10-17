package com.endsound.jackson.general.bean;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class JsonUnwrappedBean {
    public Integer id;
    @JsonUnwrapped
    public Name name;

    public static class Name {
        public String firstName;
        public String lastName;

        public Name(){}

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    public JsonUnwrappedBean(){}

    public JsonUnwrappedBean(Integer id, Name name) {
        this.id = id;
        this.name = name;
    }
}
