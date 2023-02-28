package com.example.lab1enterprise.resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.Produces;

@ApplicationScoped

public class Resources {

    @Produces
    public Jsonb createJsonB() {
        return JsonbBuilder.create();
    }
}
