package br.com.amedigital.controller;


import br.com.amedigital.model.Planet;
import br.com.amedigital.model.Results;
import br.com.amedigital.repository.PlanetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanetController {

    Planet planet =  new Planet();

    PlanetRepository repository = new PlanetRepository();

    @GetMapping("/")
    public String home(){
        return "I am teste";
    }

    @GetMapping("/planet")
    public ResponseEntity<List<Planet>> all() {
        List<Planet> planet = repository.findAll();
        if(!planet.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(planet);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(planet);
    }


    @PostMapping("/planet")
    Planet newEmployee(@RequestBody Planet newPlanet) {

        return repository.save(newPlanet);
    }

    @GetMapping("/planet/starsWars")
    public List<Results> allPlanetApiStarWars() {
        return planet.listPlanetApiStarWars();
    }

    @GetMapping("/planet/id/{id}")
    public ResponseEntity<Planet>findByIdLocal(@PathVariable(value="id") Integer id){

        Planet planet = repository.findById(id);
        if(planet == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(planet);
        return ResponseEntity.status(HttpStatus.OK).body(planet);
    }

    @GetMapping("/planet/name/{name}")
    public Planet findByNameLocal(@PathVariable(value="name") String name){
        return repository.findByName(name);
    }

    @DeleteMapping("/planet/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
