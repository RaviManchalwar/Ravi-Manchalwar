package com.read.textfile.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

    @EmbeddedId
    private PersonId personId;

    
    private String name;
    private int yearOfService;

    public Person() {
    }

    public Person(PersonId personId, String name, int yearOfService) {
        this.personId = personId;
        this.name = name;
        this.yearOfService = yearOfService;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public void setPersonId(PersonId personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfService() {
        return yearOfService;
    }

    public void setYearOfService(int yearOfService) {
        this.yearOfService = yearOfService;
    }
}
