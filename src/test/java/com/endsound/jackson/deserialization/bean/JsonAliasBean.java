package com.endsound.jackson.deserialization.bean;

import com.fasterxml.jackson.annotation.JsonAlias;

public class JsonAliasBean {
    @JsonAlias({ "fName", "f_name" })
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public JsonAliasBean setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}
