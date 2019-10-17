package com.endsound.jackson.serialization.bean.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.sql.Date;
import java.text.MessageFormat;

public class MyDateSerializer extends StdSerializer<Date> {
    public MyDateSerializer(){
        this(null);
    }

    protected MyDateSerializer(Class<Date> t) {
        super(t);
    }

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(MessageFormat.format("{0,date,yyyyMMdd}", value));
    }
}
