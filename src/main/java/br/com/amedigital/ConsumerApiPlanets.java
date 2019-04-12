package br.com.amedigital;

import br.com.amedigital.model.Planet;
import br.com.amedigital.model.Results;
import br.com.amedigital.model.ReturnApi;
import br.com.amedigital.repository.PlanetRepository;
import br.com.amedigital.util.JPAUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ConsumerApiPlanets {


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApiPlanets.class, args);
        ConsumerApiPlanets consumerApiPlanets = new ConsumerApiPlanets();
        Planet recordsPlanet = new Planet();
        recordsPlanet.insertPlanetDataBase();
    }
}