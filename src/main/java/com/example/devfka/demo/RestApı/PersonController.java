package com.example.devfka.demo.RestApı;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.devfka.demo.Service.PersonService;
import com.example.devfka.demo.entities.Person;

@RestController
@RequestMapping("/persons")
public class PersonController {

	private PersonService _personService;
	
	public PersonController(PersonService personService) {
		this._personService=personService;
	}
	
	@GetMapping
	public List<Person> getAllUser(){
		return _personService.getAll();
	}
	
	@GetMapping("/{id}")
	public Person getOnePersonById(@PathVariable int id) {
		return _personService.getPersonById(id);
	}
	
	@PostMapping()
	public void save(@RequestBody Person newPerson) {
			_personService.saveOnePerson(newPerson);
	}
	
	@PutMapping("/{id}")
	public Person updatePerson(@PathVariable int id,@RequestBody Person newPerson) {
		return _personService.updatePerson(id, newPerson);
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable int id) {
		_personService.deleteById(id);
	}
}
