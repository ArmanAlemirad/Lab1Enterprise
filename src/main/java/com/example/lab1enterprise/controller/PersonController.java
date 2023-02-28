package com.example.lab1enterprise.controller;

import com.example.lab1enterprise.entity.Persons;
import com.example.lab1enterprise.exception.idNotFoundException;
import com.example.lab1enterprise.repository.PersonRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("persons")
public class PersonController {

    @Inject
    PersonRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persons> getAllPersons(){
        return repository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOnePerson(@PathParam("id") Long id){
        var person = repository.findOne(id);
        if (person.isPresent())
            return Response.ok().entity(person.get()).build();
        //return Response.status(404).build();
        throw new idNotFoundException("Id is not found: " + id + " Please try another id");
    }

}
