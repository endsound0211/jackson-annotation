package com.endsound.jackson.general;

import com.endsound.jackson.general.bean.JsonFormatBean;
import com.endsound.jackson.general.bean.JsonUnwrappedBean;
import com.endsound.jackson.general.bean.JsonViewBean;
import com.endsound.jackson.general.bean.Views;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Date;
import java.text.MessageFormat;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class GeneralTest {
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void usingJsonFormat() throws IOException {
        JsonFormatBean bean = new JsonFormatBean(Date.valueOf(LocalDate.of(2019, 1, 1)));
        String result = objectMapper.writeValueAsString(bean);
        assertThat(result, containsString("20190101"));

        JsonFormatBean deBean = objectMapper.readValue(result, JsonFormatBean.class);
        assertEquals("20190101", MessageFormat.format("{0,date,yyyyMMdd}", deBean.getEventDate()));
    }

    @Test
    public void usingJsonUnwrapped() throws IOException{
        JsonUnwrappedBean.Name name = new JsonUnwrappedBean.Name("John", "Doe");
        JsonUnwrappedBean bean = new JsonUnwrappedBean(1, name);

        String result = new ObjectMapper().writeValueAsString(bean);

        assertThat(result, containsString("John"));
        assertThat(result, not(containsString("name")));

        JsonUnwrappedBean deBean = objectMapper.readValue(result, JsonUnwrappedBean.class);
        assertEquals("John", deBean.name.firstName);
    }

    @Test
    public void usingJsonView() throws IOException {
        JsonViewBean bean = new JsonViewBean("public item", "internal item");
        String result = objectMapper.writerWithView(Views.Public.class)
                .writeValueAsString(bean);

        assertThat(result, containsString("publicItem"));
        assertThat(result, not(containsString("internalItem")));

        String json = "{\"publicItem\":\"public item\",\"internalItem\":\"internal item\"}";
        JsonViewBean deBean = objectMapper.readerWithView(Views.Public.class)
                .forType(JsonViewBean.class)
                .readValue(json);
        assertNull(deBean.internalItem);
    }
}
