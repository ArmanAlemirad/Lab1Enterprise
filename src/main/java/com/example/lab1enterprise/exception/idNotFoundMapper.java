package com.example.lab1enterprise.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class idNotFoundMapper implements ExceptionMapper<idNotFoundException> {
    @Override
    public Response toResponse(idNotFoundException e) {
        return Response.status(404).entity(e.getMessage()).build();
    }
}
