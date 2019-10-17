package com.endsound.jackson.deserialization;

import com.endsound.jackson.deserialization.bean.*;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.MessageFormat;

import static org.junit.Assert.assertEquals;

public class DeserializationTest {
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void usingJsonCreator() throws IOException {
        String json = "{\"id\":1,\"theName\":\"My bean\"}";
        JsonCreatorBean bean = objectMapper.readValue(json, JsonCreatorBean.class);
        assertEquals("My bean", bean.getName());
    }

    @Test
    public void usingJacksonInject() throws IOException {
        String json = "{\"name\":\"My bean\"}";
        InjectableValues injectableValues = new InjectableValues.Std()
                .addValue(Integer.class, 1);
        JacksonInjectBean bean = objectMapper.reader(injectableValues)
                .forType(JacksonInjectBean.class)
                .readValue(json);
        assertEquals(Integer.valueOf(1), bean.getId());
        assertEquals("My bean", bean.getName());
    }

    @Test
    public void usingJsonAnySetter() throws IOException {
        String json = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";
        JsonAnySetterBean bean = objectMapper.readValue(json, JsonAnySetterBean.class);
        assertEquals("My bean", bean.getName());
        assertEquals("val2", bean.getProperties().get("attr2"));
    }

    @Test
    public void usingJsonSetter() throws IOException {
        String json = "{\"theName\":\"My bean\"}";
        JsonSetterBean bean = objectMapper.readValue(json, JsonSetterBean.class);
        assertEquals("My bean", bean.getName());
    }

    @Test
    public void usingJsonDeserialize() throws IOException {
        String json = "{\"eventDate\":\"20190101\"}";
        JsonDeserializeBean bean = objectMapper.readValue(json, JsonDeserializeBean.class);
        assertEquals("20190101", MessageFormat.format("{0,date,yyyyMMdd}", bean.getEventDate()));
    }

    @Test
    public void usingJsonAlias() throws IOException {
        String json = "{\"f_name\":\"Ken\",\"fName\":\"Andy\"}";
        JsonAliasBean bean = objectMapper.readValue(json, JsonAliasBean.class);
        assertEquals("Andy", bean.getFirstName());
    }

}
