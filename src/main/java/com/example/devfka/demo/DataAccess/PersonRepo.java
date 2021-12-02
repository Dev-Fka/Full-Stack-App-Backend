package com.example.devfka.demo.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.devfka.demo.entities.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer>{
	
	Person findByIdentityNumber(String identyNum);
}
