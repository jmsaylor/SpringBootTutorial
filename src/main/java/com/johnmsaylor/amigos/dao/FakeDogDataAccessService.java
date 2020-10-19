package com.johnmsaylor.amigos.dao;

import com.johnmsaylor.amigos.model.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("dogDao")
public class FakeDogDataAccessService implements DogDao{

    private static List<Dog> dogs = new ArrayList<>();

    @Override
    public int insertDog(Dog dog) {
        dogs.add(new Dog(dog.getName(), dog.getAge(), dog.getFavoriteThings()));
        return 1;
    }

    @Override
    public List<Dog> getAllDogs() {
        return dogs;
    }
}
