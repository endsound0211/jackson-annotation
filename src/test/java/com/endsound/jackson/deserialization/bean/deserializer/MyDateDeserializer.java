package com.endsound.jackson.deserialization.bean.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MyDateDeserializer extends StdDeserializer<Date> {
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyyMMdd");

    public MyDateDeserializer(){
        this(null);
    }

    public MyDateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            return new Date(FORMATTER.parse(p.getText()).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
