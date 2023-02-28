package com.example.lab1enterprise.mapper;

import com.example.lab1enterprise.dto.PersonDto;
import com.example.lab1enterprise.entity.Persons;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PersonMapper {
    public List<PersonDto> map(List<Persons> all) {
        return all.stream().map(PersonDto::new).toList();
    }

    public Persons map(PersonDto person) {
        var f = new Persons();
        f.setId( person.getId());
        f.setName(person.getName());
        return f;
    }

    public PersonDto map(Persons persons) {
        return new PersonDto(persons);
    }
}
