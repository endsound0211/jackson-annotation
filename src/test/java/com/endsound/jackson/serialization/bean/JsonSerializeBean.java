package com.endsound.jackson.serialization.bean;

import com.endsound.jackson.serialization.bean.serializer.MyDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.Date;

public class JsonSerializeBean {
    @JsonSerialize(using = MyDateSerializer.class)
    private Date eventDate;

    public JsonSerializeBean(Date eventDate) {
        this.eventDate = eventDate;
    }
}
