package com.johnmsaylor.amigos.dao;

import com.johnmsaylor.amigos.model.Dog;

import java.util.List;
import java.util.UUID;

public interface DogDao {
    int insertDog(Dog dog);

    List<Dog> getAllDogs();
}
