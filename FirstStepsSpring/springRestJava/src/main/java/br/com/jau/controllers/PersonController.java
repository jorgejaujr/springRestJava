package br.com.jau.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.jau.util.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jau.data.vo.v1.PersonVO;
import br.com.jau.services.PersonServices;

@RestController
//@RequestMapping("/person")
@RequestMapping("api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	
	@GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public PersonVO findById(
			@PathVariable(value ="id") Long id){
		return service.findById(id);
		
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public List<PersonVO> findAll(){
		return service.findAll();
		
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
			        produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public PersonVO create(@RequestBody PersonVO person){
		return service.create(person);
		
	}
	
//	@PostMapping(value = "/v2",consumes ={MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
//	        produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
//    public PersonVOV2 createV2(@RequestBody PersonVOV2 person){
//         return service.createV2(person);
//
//    }
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
	        produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public PersonVO update(@RequestBody PersonVO person){
		return service.update(person);
	
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(
			@PathVariable(value ="id") Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	


}
