package com.example.lab1enterprise.dto;

import com.example.lab1enterprise.entity.Persons;

public class PersonDto {
    private Long id;
    private String name;
    public PersonDto() {
    }
    public PersonDto(Persons persons) {
        this.id = persons.getId();
        this.name = persons.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
