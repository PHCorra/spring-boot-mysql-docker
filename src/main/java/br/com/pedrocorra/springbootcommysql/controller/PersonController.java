package br.com.pedrocorra.springbootcommysql.controller;

import br.com.pedrocorra.springbootcommysql.controller.dto.PersonRq;
import br.com.pedrocorra.springbootcommysql.controller.dto.PersonRs;
import br.com.pedrocorra.springbootcommysql.model.Person;
import br.com.pedrocorra.springbootcommysql.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {

    // @Autowired -> this is some way to do that
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @GetMapping("/")
    public List<PersonRs> findAll() {
        var persons = personRepository.findAll();
        return persons.stream().map(PersonRs::converter).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PersonRs findById(@PathVariable("id") Long id) {
        var person = personRepository.getOne(id);
        return PersonRs.converter(person);
    }

    @PostMapping("/")
    public void savePerson(@RequestBody PersonRq person) {
        var p = new Person();
        p.setName(person.getName());
        p.setSurname(person.getSurname());
        personRepository.save(p);
    }

    @PutMapping("/{id}")
    public void updatePerson(@RequestBody PersonRq person, @PathVariable("id") Long id) throws Exception {
        var p = personRepository.findById(id);

        if(p.isPresent()) {
            var personSave = p.get();
            personSave.setName(person.getName());
            personSave.setSurname(person.getSurname());
            personRepository.save(personSave);
        } else {
            throw new Exception("Person not found");
        }
    }

}
