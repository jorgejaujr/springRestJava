package br.com.jau.services;


import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jau.Model.Person;
import br.com.jau.exceptions.ResourceNotFoundException;
import br.com.jau.repositories.PersonRepository;

@Service
public class PersonServices {
	
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		
		logger.info("Finding all people");
		
		return repository.findAll() ;
		
	}
	//Ponto de recuperacao dos dados via base de dados
	public Person create(Person person) {
		
		logger.info("Creating one person");
		
		 
		return repository.save(person);
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person");
		
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		repository.delete(entity);
		
	}
	public Person update(Person person) {
		
		logger.info("Updating one person");
		
		var entity = repository.findById(person.getID()).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		
		 entity.setFirstName(person.getFirstName());
		 entity.setLastName(person.getLastName());
		 entity.setAddress(person.getAddress());
		 entity.setGender(person.getGender());
		
		 
		return repository.save(person);
	}
	
	public Person findById(Long id) {
		
		logger.info("Finding one person");
		 
		 /*Ponto de chamada de banco de dados*/
	
		 return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		
	}

}
