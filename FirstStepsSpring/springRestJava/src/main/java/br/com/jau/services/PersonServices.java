package br.com.jau.services;


import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import br.com.jau.Model.Person;
import br.com.jau.controllers.PersonController;
import br.com.jau.data.vo.v1.PersonVO;
//import br.com.jau.data.vo.v2.PersonVOV2;
import br.com.jau.exceptions.ResourceNotFoundException;
import br.com.jau.mapper.DozerMapper;
import br.com.jau.mapper.custom.PersonMapper;
import br.com.jau.repositories.PersonRepository;

@Service
public class PersonServices {
	
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() {
		
		logger.info("Finding all people");
		
		
		var persons = DozerMapper.parseListObjects(repository.findAll(), PersonVO.class) ;
		persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
		return persons;
		
	}
	
    public PersonVO findById(Long id) {
		
		logger.info("Finding one person");
		 
		var entity =  repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id")); 
		var vo = DozerMapper.parseObject(entity, PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
		
	}
	
	public PersonVO create(PersonVO person) {
		
		logger.info("Creating one person");	
		
		var entity = DozerMapper.parseObject(person, Person.class);
		
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
//	public PersonVOV2 createV2(PersonVOV2 person) {
//        logger.info("Creating one person with V2");	
//		
//		var entity = mapper.convertVoToEntity(person);
//		
//		var vo = mapper.convertEntityToVo(repository.save(entity));
//		 
//		return vo;
//	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person");
		
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		repository.delete(entity);
		
	}
	public PersonVO update(PersonVO person) {
		
		logger.info("Updating one person");
		
		var entity = repository.findById(person.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		
		 entity.setFirstName(person.getFirstName());
		 entity.setLastName(person.getLastName());
		 entity.setAddress(person.getAddress());
		 entity.setGender(person.getGender());
		
		 
		var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	
	
	

}
