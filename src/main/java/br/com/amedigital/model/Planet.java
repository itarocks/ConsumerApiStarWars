package br.com.amedigital.model;

import br.com.amedigital.repository.PlanetRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Planet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String climate;

    @Column(nullable = false, unique=true)
    private String name;

    private String terrain;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getClimate() {
        return climate;
    }

    public String getName() {
        return name;
    }

    public String getTerrain() {
        return terrain;
    }

    public ResponseEntity<ReturnApi> receivedPlanets(String url) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("Headers", headers);
        ResponseEntity<ReturnApi> response = restTemplate.exchange(url, HttpMethod.GET, entity, ReturnApi.class);
        return response;
    }

    public List<Results> listPlanetApiStarWars(){

        String url = "https://swapi.co/api/planets/";
        List<Results>  planets = new ArrayList<>();
        boolean moreRecord = true;

        while (moreRecord) {

            ResponseEntity<ReturnApi> responseMetodo = receivedPlanets(url);

            for (Results planet : responseMetodo.getBody().getResults()) {

                planet.getName();
                planets.add(planet);
            }

            if (responseMetodo.getBody().getNext() == null){
                moreRecord = false;
            }

            url = responseMetodo.getBody().getNext();
        }

        return planets;
    }

    public void insertPlanetDataBase(){

        List<Results> listWithPlanets = new ArrayList<>(listPlanetApiStarWars());

        for (Results listPlanets : listWithPlanets) {

            Planet planet = new Planet();
            planet.setName(listPlanets.getName());
            planet.setClimate(listPlanets.getClimate());
            planet.setTerrain(listPlanets.getTerrain());
            planet.insertRecord(planet);
        }

    }

    public void insertRecord(Planet planet){

        PlanetRepository repository = new PlanetRepository();
        repository.save(planet);
    }

    @Override
    public String toString() {
        return "Planet{" +
                ", climate='" + climate + '\'' +
                ", name='" + name + '\'' +
                ", terrain='" + terrain + '\'' +
                '}';
    }
}
