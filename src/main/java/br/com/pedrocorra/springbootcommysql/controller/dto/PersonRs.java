package br.com.pedrocorra.springbootcommysql.controller.dto;

import br.com.pedrocorra.springbootcommysql.model.Person;

public class PersonRs {

    private Long id;
    private String name;
    private String surname;

    public static PersonRs converter(Person p) {
        var person = new PersonRs();
        person.setId(p.getId());
        person.setName(p.getName());
        person.setSurname(p.getSurname());
        return person;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
