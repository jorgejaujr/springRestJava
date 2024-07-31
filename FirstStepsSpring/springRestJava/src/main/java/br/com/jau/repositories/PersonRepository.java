package br.com.jau.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jau.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
