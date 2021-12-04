package com.example.devfka.demo.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.devfka.demo.DataAccess.*;
import com.example.devfka.demo.entities.*;
import com.example.devfka.demo.entities.Person;

@Service
public class SchoolService {

	SchoolRepo schoolRepo;
	PersonService personService;

	public SchoolService(SchoolRepo schoolRepo,PersonService personservice) {
		this.schoolRepo = schoolRepo;
		this.personService=personservice;
	}
	
	public List<School> getAll(){
		return schoolRepo.findAll();
	}
	
	public List<School> getByPersonId(int id) {
		List<School> schools=schoolRepo.findByPersonId(id);
		return schools;
	}
		
	
	public List<School> getBySchoolName(String schoolName){
		return schoolRepo.findByschoolNameContaining(schoolName);
	}
	
	public School saveSchool(int id,School newSchool) {
		Person person=personService.getPersonById(id);
		if(person!=null) {
			School schoolOfPerson=new School();
			schoolOfPerson.setPerson(person);
			schoolOfPerson.setSchoolName(newSchool.getSchoolName());
			schoolOfPerson.setFinishDate(newSchool.getFinishDate());
			schoolRepo.save(schoolOfPerson);
			return schoolOfPerson;
		}else 
		{
			return null;
		}
	}
	
	
	public School updateOneSchool(int id,School newSchool) {
		Optional<School> schoolForUpdate=schoolRepo.findById(id);
		if(schoolForUpdate.isPresent()) {
			School schoolForUpdateNew=schoolForUpdate.get();
			schoolForUpdateNew.setFinishDate(newSchool.getFinishDate());
			schoolForUpdateNew.setSchoolName(newSchool.getSchoolName());
			return schoolRepo.save(schoolForUpdateNew);
		}
		return null;
	}
	
	public void deleteSchool(int id) {
		schoolRepo.deleteById(id);
	}
}
