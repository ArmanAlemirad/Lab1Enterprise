package com.example.lab1enterprise.exception;

import jakarta.ws.rs.WebApplicationException;

public class idNotFoundException extends WebApplicationException {
    public idNotFoundException(){
        super();
    }

    public idNotFoundException(String message){
        super(message);
    }
}
