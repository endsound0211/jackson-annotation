package com.endsound.jackson.polymorphicType;

import com.endsound.jackson.polymorphicType.bean.Zoo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PolymorphicTypeTest {
    @Test
    public void serializationTest() throws JsonProcessingException {
        Zoo.Dog dog = new Zoo.Dog("lacy", 112.0);
        Zoo zoo = new Zoo(dog);

        String result = new ObjectMapper().writeValueAsString(zoo);

        assertThat(result, containsString("type"));
        assertThat(result, containsString("dog"));
    }

    @Test
    public void deserializationTest() throws IOException {
        String json = "{\"animal\":{\"type\":\"cat\",\"name\":\"lacy\",\"lives\":10}}";
        Zoo zoo = new ObjectMapper().readValue(json, Zoo.class);

        assertEquals("lacy", zoo.animal.name);
        assertEquals(Zoo.Cat.class, zoo.animal.getClass());
        assertEquals(Integer.valueOf(10), ((Zoo.Cat)zoo.animal).lives);
    }
}
