package com.techzone.taskcontroller.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techzone.taskcontroller.domain.Person;
import com.techzone.taskcontroller.dto.PersonDTO;
import com.techzone.taskcontroller.dto.PersonNewDTO;
import com.techzone.taskcontroller.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonRest {

	@Autowired
	PersonService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> findbyId(@PathVariable Integer id){
		Person person = service.findById(id);
		return ResponseEntity.ok().body(person);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PersonDTO>> findAll(){
		List<Person> personList = service.findAll();
		List<PersonDTO> personDTOs = personList.stream().map((obj) -> new PersonDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(personDTOs);
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Person> save(@Valid @RequestBody PersonNewDTO personDTO){
		Person person = service.fromDTO(personDTO);
		return ResponseEntity.ok().body(service.save(person));
	}
	
	
}
