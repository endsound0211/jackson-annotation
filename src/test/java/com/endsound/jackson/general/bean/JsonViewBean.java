package com.endsound.jackson.general.bean;

import com.fasterxml.jackson.annotation.JsonView;

public class JsonViewBean {
    @JsonView(Views.Public.class)
    public String publicItem;
    @JsonView(Views.Internal.class)
    public String internalItem;

    public JsonViewBean() {
    }

    public JsonViewBean(String publicItem, String internalItem) {
        this.publicItem = publicItem;
        this.internalItem = internalItem;
    }
}
