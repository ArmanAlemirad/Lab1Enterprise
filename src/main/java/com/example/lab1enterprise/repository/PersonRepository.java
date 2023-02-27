package com.example.lab1enterprise.repository;

import com.example.lab1enterprise.entity.Persons;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.ApplicationPath;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PersonRepository {

    @PersistenceContext
    EntityManager entityManager;


    public List<Persons> findAll(){
        var query = entityManager.createQuery("select p from Persons p");
        return (List<Persons>) query.getResultList();

    }

    public Optional<Persons> findOne(Long id){
        return Optional.ofNullable(entityManager.find(Persons.class, id));
    }
    public void insertPerson(Persons persons){
        entityManager.persist(persons);
    }

    public void deletePerson(Long id){
        var persons = findOne(id);
        persons.ifPresent((p)-> entityManager.remove(p));
    }

    public Persons updatePerson(Long id, Persons person){
        var entity = entityManager.find(Persons.class, id);
        entity.setName(person.getName());
        entity.setPassword(person.getPassword());
        entityManager.persist(entity);
        return entity;
    }

    public List<Persons> findAllByName(String name) {
        var query = entityManager.createQuery("select p from Persons p where p.name like :name");
        query.setParameter("name", name);
        return (List<Persons>) query.getResultList();
    }

}
