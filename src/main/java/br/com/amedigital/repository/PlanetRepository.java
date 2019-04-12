package br.com.amedigital.repository;

import br.com.amedigital.model.Planet;
import br.com.amedigital.util.JPAUtil;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlanetRepository implements JpaRepository<Planet, Long> {

    @PersistenceContext
    EntityManager em = new JPAUtil().getEntityManager();


    @Override
    public List<Planet> findAll() {
        return em.createQuery("select climate from Planet climate", Planet.class).getResultList();
    }

    @Override
    public List<Planet> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Planet> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Planet> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Planet planet) {

    }

    @Override
    public void deleteAll(Iterable<? extends Planet> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Planet> S save(S s) {

        em.getTransaction().begin();

        try{

            em.persist(s);

        }catch(Exception e){
            System.out.println("Registro já existe no banco de dados" + s.getName());
        }

        em.getTransaction().commit();
        em.close();
        return  s;
    }

    @Override
    public <S extends Planet> List<S> saveAll(Iterable<S> iterable) {

        List<S> result = new ArrayList<S>();
        for (S entity : iterable) {
            result.add(save(entity));
        }
        return result;
    }

    public Planet findById(Integer id) {

        TypedQuery<Planet> query  = em.createQuery("Select climate From Planet climate where climate.id = '" + id + "'", Planet.class);
        return query.getSingleResult();
    }

    public Planet findByName(String name) {

        TypedQuery<Planet> query  = em.createQuery("Select climate From Planet climate where climate.name = '" + name + "'", Planet.class);
        return query.getSingleResult();
    }

    @Override
    public Optional<Planet> findById(Long aLong) {

        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Planet> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Planet> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Planet getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Planet> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Planet> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Planet> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Planet> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Planet> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Planet> boolean exists(Example<S> example) {
        return false;
    }
}
