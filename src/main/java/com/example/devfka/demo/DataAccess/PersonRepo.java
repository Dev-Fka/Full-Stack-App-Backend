package com.example.devfka.demo.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devfka.demo.entities.Person;
//repository extends JpaRepository field,methods etc.
public interface PersonRepo extends JpaRepository<Person, Long>{
	
	
}
