package com.johnmsaylor.amigos.dao;

import com.johnmsaylor.amigos.model.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<Dog> getSpecificDog(String name) {
        return dogs.stream().filter(dog -> dog.getName().equals(name)).findFirst();
    }

    @Override
    public int deleteDog(String name) {
        var dogMaybe = getSpecificDog(name);
        if (dogMaybe.isEmpty()) {
            return 0;
        }
        dogs.remove(dogMaybe.get());
        return 1;
    }

    @Override
    public int changeDogName(String name, String newName) {
        var dog = getSpecificDog(name);
        int indexOfDogToUpdate = dogs.indexOf(dog.get());
        if (indexOfDogToUpdate < 0)
            return 0;
        dogs.set(indexOfDogToUpdate, new Dog(newName, dog.get().getAge(), dog.get().getFavoriteThings()));
        return 1;
    }


}
