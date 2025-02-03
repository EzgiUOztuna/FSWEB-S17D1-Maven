package com.workintech.fswebs17d1.controller;
import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    @PostConstruct
    public void loadAll(){
        this.animals=new HashMap<>();
        this.animals.put(1, new Animal(1, "maymun"));
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal){
        this.animals.put(animal.getId(), animal);
        return animal;
    }

    @GetMapping
    public List<Animal> getAnimals(){
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable int id){
        if(id<0){
            return null;
        }
        return this.animals.get(id);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal newAnimal){
        animals.replace(id, newAnimal);
        return this.animals.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id){
        this.animals.remove(id);

    }

}
