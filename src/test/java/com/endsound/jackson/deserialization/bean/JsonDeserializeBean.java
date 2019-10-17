package com.endsound.jackson.deserialization.bean;

import com.endsound.jackson.deserialization.bean.deserializer.MyDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.sql.Date;

public class JsonDeserializeBean {
    @JsonDeserialize(using = MyDateDeserializer.class)
    private Date eventDate;

    public Date getEventDate() {
        return eventDate;
    }

    public JsonDeserializeBean setEventDate(Date eventDate) {
        this.eventDate = eventDate;
        return this;
    }
}
