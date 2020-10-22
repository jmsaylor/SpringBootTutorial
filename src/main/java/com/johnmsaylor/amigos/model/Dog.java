package com.johnmsaylor.amigos.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Dog {
    private String name;
    private int age;
    private String[] favoriteThings;

    public Dog(){};

    public Dog(@JsonProperty("name") String name,
               @JsonProperty("age") int age,
               @JsonProperty("favoriteThings") String[] favoriteThings) {
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

    public String[] getFavoriteThings() {
        return favoriteThings;
    }
}
