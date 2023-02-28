package com.example.lab1enterprise.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("persons")
public class PersonController {

    @GET
    public Response getAllPersons(){
        return Response.ok().entity("This is working").build();

    }
}
