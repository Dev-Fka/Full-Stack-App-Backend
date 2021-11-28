package com.example.devfka.demo.Service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.devfka.demo.DataAccess.PersonRepo;
import com.example.devfka.demo.entities.Person;

@Service

public class PersonService {
	
	PersonRepo personRepo;

	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
		
	public List<Person> getAll(){
		return personRepo.findAll();
	}
	public Person getPersonById(Long id) {
		return personRepo.findById(id).orElse(null);
	}
	public Person saveOnePerson(Person newPerson) {
		return personRepo.save(newPerson);
	}
	public Person updatePerson(Long id,Person newPerson) {
		Optional<Person> person=personRepo.findById(id);
		if(person.isPresent()) {
			Person foundedPerson =person.get();
			foundedPerson.setName(newPerson.getName());
			foundedPerson.setLastName(newPerson.getLastName());
			foundedPerson.setBirthDate(newPerson.getBirthDate());
			personRepo.save(foundedPerson);
			return foundedPerson;
		}else {
			return null;
		}
	}
	public void deleteById(Long id) {
		personRepo.deleteById(id);
	}
}

