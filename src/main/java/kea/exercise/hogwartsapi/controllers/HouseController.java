package kea.exercise.hogwartsapi.controllers;

import kea.exercise.hogwartsapi.models.House;
import kea.exercise.hogwartsapi.repositories.HouseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/houses")
public class HouseController {

    private HouseRepository repo;
    public HouseController(HouseRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<House> getAllHouses() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public House getHouseByName(@PathVariable String name) {
        return repo.findById(name).orElse(null);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public House createHouse(@RequestBody House house) {
//        return repo.save(house);
//    }

//    @PutMapping("/{id}")
//    public House updateHouse(@PathVariable int id, @RequestBody House house) {
//        house.setId(id);
//        return repo.save(house);
//    }
}
