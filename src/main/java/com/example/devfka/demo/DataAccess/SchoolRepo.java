package com.example.devfka.demo.DataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.devfka.demo.entities.*;

@Repository
public interface SchoolRepo extends JpaRepository<School,Integer>{
	

	List<School> findByschoolNameContaining(String schoolName);
	
	List<School> findByPersonId(int id);
}
