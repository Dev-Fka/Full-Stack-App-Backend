package com.example.devfka.demo.DataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devfka.demo.entities.Education;

public interface EducationRepo extends JpaRepository<Education,Integer>{
	
	//List for specific School
	
	List<Education> findBySchoolNameContaining(String schoolName);
	
	List <Education> findByPersonId(Long personId);
}
