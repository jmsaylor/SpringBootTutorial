package com.johnmsaylor.amigos.dao;

import com.johnmsaylor.amigos.model.Dog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DogDao {
    int insertDog(Dog dog);

    List<Dog> getAllDogs();

    Optional<Dog> getSpecificDog(String name);

    int deleteDog(String name);

    int changeDogName(String name, String newName);
}
