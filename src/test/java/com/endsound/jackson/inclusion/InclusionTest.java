package com.endsound.jackson.inclusion;

import com.endsound.jackson.inclusion.bean.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class InclusionTest {
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void usingJsonIgnoreProperties() throws JsonProcessingException {
        JsonIgnorePropertiesBean bean = new JsonIgnorePropertiesBean(1, "My bean");
        String result = objectMapper.writeValueAsString(bean);

        assertThat(result, containsString("My bean"));
        assertThat(result, not(containsString("id")));
    }

    @Test
    public void usingJsonIgnore() throws JsonProcessingException{
        JsonIgnoreBean bean = new JsonIgnoreBean(1, "My bean");
        String result = objectMapper.writeValueAsString(bean);

        assertThat(result, containsString("My bean"));
        assertThat(result, not(containsString("id")));
    }

    @Test
    public void usingJsonIgnoreType() throws JsonProcessingException {
        JsonIgnoreTypeBean bean = new JsonIgnoreTypeBean(1, new JsonIgnoreTypeBean.Name("Andy", "Tea"));
        String result = objectMapper.writeValueAsString(bean);

        assertThat(result, containsString("id"));
        assertThat(result, not(containsString("name")));
    }

    @Test
    public void usingJsonInclude() throws JsonProcessingException{
        JsonIncludeBean bean = new JsonIncludeBean(1, null);
        String result = objectMapper.writeValueAsString(bean);

        assertThat(result, containsString("id"));
        assertThat(result, not(containsString("name")));
    }


}
