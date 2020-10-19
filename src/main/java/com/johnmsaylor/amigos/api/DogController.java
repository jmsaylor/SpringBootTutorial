package com.johnmsaylor.amigos.api;

import com.johnmsaylor.amigos.model.Dog;
import com.johnmsaylor.amigos.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/dogs")
@RestController
public class DogController {
    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping
    public int addDog(@RequestBody Dog dog) {
        return dogService.addDog(dog);
    }

    @GetMapping
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }
}
