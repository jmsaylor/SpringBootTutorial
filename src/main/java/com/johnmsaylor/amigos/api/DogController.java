package com.johnmsaylor.amigos.api;

import com.johnmsaylor.amigos.model.Dog;
import com.johnmsaylor.amigos.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(path = "{id}")
    public Dog getSpecificDog(@PathVariable("id") String name) {
        return dogService.getSpecificDog(name).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deleteDog(@PathVariable("id") String name) {
        return dogService.deleteDog(name);
    }

    @PutMapping(path = "{id}")
    public int changeDogName(@PathVariable("id") String id,
                             @Valid @NonNull @RequestBody Dog dog) {
        return dogService.changeDogName(id, dog.getName());
    }
}
