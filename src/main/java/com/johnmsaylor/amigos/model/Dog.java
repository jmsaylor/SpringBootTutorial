package com.johnmsaylor.amigos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Dog {
    private String name;
    private int age;
    private List<String> favoriteThings;

    public Dog(){};

    public Dog(@JsonProperty("name") String name,
               @JsonProperty("age") int age,
               @JsonProperty("favoriteThings") List<String> favoriteThings) {
        this.name = name;
        this.age = age;
        this.favoriteThings = favoriteThings;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getFavoriteThings() {
        return favoriteThings;
    }
}
