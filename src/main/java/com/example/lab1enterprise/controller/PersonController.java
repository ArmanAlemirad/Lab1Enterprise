package com.example.lab1enterprise.controller;

import com.example.lab1enterprise.dto.PersonDto;
import com.example.lab1enterprise.entity.Persons;
import com.example.lab1enterprise.exception.idNotFoundException;
import com.example.lab1enterprise.mapper.PersonMapper;
import com.example.lab1enterprise.repository.PersonRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("persons")
public class PersonController {

    @Inject
    PersonRepository repository;

    @Inject
    PersonMapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonDto> getAllPersons(@QueryParam("name") String name){
        return mapper.map(repository.findAll());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOnePerson(@PathParam("id") Long id){
        var person = repository.findOne(id);
        if (person.isPresent())
            return Response.ok().entity(person.get()).build();
        throw new idNotFoundException("Id is not found: " + id + " Please try another id");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOnePerson(Persons person){
        repository.insertPerson(person);
        return Response.created(URI.create("persons/" + person.getId())).build();
    }

    @DELETE
    @Path("/{id}")
    public void deleteOnePerson (@PathParam("id") Long id){
        repository.deletePerson(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("id") Long id, PersonDto person) {
        return Response.ok().entity(mapper.map(repository.updatePerson(id, mapper.map(person)))).build();
    }

}
