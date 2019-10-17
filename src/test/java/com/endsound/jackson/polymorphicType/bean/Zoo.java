package com.endsound.jackson.polymorphicType.bean;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

public class Zoo {
    public Animal animal;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat")
    })
    public static class Animal {
        public String name;

        public Animal(){}

        public Animal(String name) {
            this.name = name;
        }
    }

    @JsonTypeName("dog")
    public static class Dog extends Animal {
        public Double barkVolume;

        public Dog(String name, Double barkVolume) {
            super(name);
            this.barkVolume = barkVolume;
        }
    }

    @JsonTypeName("cat")
    public static class Cat extends Animal {
        public Integer lives;

        public Cat(){}

        public Cat(String name, Integer lives) {
            super(name);
            this.lives = lives;
        }
    }

    public Zoo(Animal animal) {
        this.animal = animal;
    }

    public Zoo(){}
}
