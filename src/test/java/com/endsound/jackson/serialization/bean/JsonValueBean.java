package com.endsound.jackson.serialization.bean;

public class JsonValueBean {
    private TypeEnum type;

    public JsonValueBean(TypeEnum type) {
        this.type = type;
    }

    public TypeEnum getType() {
        return type;
    }

    public JsonValueBean setType(TypeEnum type) {
        this.type = type;
        return this;
    }
}
