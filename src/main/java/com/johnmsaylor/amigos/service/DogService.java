package com.johnmsaylor.amigos.service;

import com.johnmsaylor.amigos.dao.DogDao;
import com.johnmsaylor.amigos.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {
    private final DogDao dogDao;

    @Autowired
    public DogService(@Qualifier("dogDao") DogDao dogDao) {
        this.dogDao = dogDao;
    }

    public int addDog(Dog dog) {
        return dogDao.insertDog(dog);
    }

    public List<Dog> getAllDogs() {
        return dogDao.getAllDogs();
    }

    public Optional<Dog> getSpecificDog(String name) {
        return dogDao.getSpecificDog(name);
    }

    public int deleteDog(String name) {
        return dogDao.deleteDog(name);
    }

    public int changeDogName(String name, String newName) {
        return dogDao.changeDogName(name, newName);
    }

}
