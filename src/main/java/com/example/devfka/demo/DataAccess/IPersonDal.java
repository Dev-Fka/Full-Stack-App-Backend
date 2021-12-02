package com.example.devfka.demo.DataAccess;

import java.util.List;

import com.example.devfka.demo.entities.Person;

public interface IPersonDal {
	//I'm create that for maybe we want Hibernate ORM.
	
	List<Person> getAll();
	void add(Person person);
	void update(Person person);
	void delete(Person person);
	Person getById(int id);
}
