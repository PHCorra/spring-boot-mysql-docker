package br.com.pedrocorra.springbootcommysql.repository;

import br.com.pedrocorra.springbootcommysql.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
