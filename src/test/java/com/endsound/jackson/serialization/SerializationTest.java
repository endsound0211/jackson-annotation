package com.endsound.jackson.serialization;

import com.endsound.jackson.serialization.bean.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class SerializationTest {
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void usingJsonAnyGetter() throws JsonProcessingException {
        JsonAnyGetterBean bean = new JsonAnyGetterBean();
        Map<String, String> properties = new HashMap<>();
        properties.put("var1", "111");
        properties.put("var2", "222");

        bean.setName("Ken")
                .setProperties(properties);

        String result = objectMapper.writeValueAsString(bean);

        assertThat(result, containsString("var1"));
        assertThat(result, containsString("var2"));
        assertThat(result, not(containsString("properties")));
    }

    @Test
    public void usingJsonGetter() throws JsonProcessingException{
        JsonGetterBean bean = new JsonGetterBean()
                .setName("Ken");

        String result = objectMapper.writeValueAsString(bean);

        assertThat(result, containsString("TheName"));
        assertThat(result, not(containsString("name")));
    }

    @Test
    public void usingJsonPropertyOrder() throws JsonProcessingException{
        JsonPropertyOrderBean bean = new JsonPropertyOrderBean(1, "Ken");

        String result = objectMapper.writeValueAsString(bean);
        assertTrue(result.indexOf("name") < result.indexOf("id"));
    }

    @Test
    public void usingJsonRawValue() throws JsonProcessingException {
        JsonRawValueBean bean = new JsonRawValueBean("{\"name\":\"Ken\"}");
        String result = objectMapper.writeValueAsString(bean);
        assertThat(result, not(containsString("{\"json\":\"{\\\"name\\\":\\\"Ken\\\"}\"}")));
    }

    @Test
    public void usingJsonValue() throws JsonProcessingException {
        JsonValueBean bean = new JsonValueBean(TypeEnum.TYPE1);
        String result = objectMapper.writeValueAsString(bean);
        assertThat(result, containsString("Type A"));
    }

    @Test
    public void usingJsonRootName() throws JsonProcessingException {
        JsonRootNameBean bean = new JsonRootNameBean("Ken");
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = objectMapper.writeValueAsString(bean);
        assertThat(result, containsString("RootName"));
    }

    @Test
    public void usingJsonSerialize() throws JsonProcessingException {
        JsonSerializeBean bean = new JsonSerializeBean(Date.valueOf(LocalDate.of(2019, 1, 1)));
        String result = objectMapper.writeValueAsString(bean);
        assertThat(result, containsString("20190101"));
    }
}
