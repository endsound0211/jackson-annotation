package com.endsound.jackson.general.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class JsonFormatBean {
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyyMMdd",
            timezone = "GMT+8")
    private Date eventDate;

    public JsonFormatBean(){}

    public JsonFormatBean(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public JsonFormatBean setEventDate(Date eventDate) {
        this.eventDate = eventDate;
        return this;
    }
}
