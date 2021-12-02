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
	
	public School saveSchool(int id,Date date,String schoolName) {
		Person person=personService.getPersonById(id);
		if(person!=null) {
			School schoolOfPerson=new School();
			schoolOfPerson.setPerson(person);
			schoolOfPerson.setSchool_name(schoolName);
			schoolOfPerson.setFinish_date(date);
			return schoolRepo.save(schoolOfPerson);
		}else 
		{
			return null;
		}
	}
	
	
	public School updateOneSchool(int id,Date date,String schoolName) {
		Optional<School> schoolInfo=schoolRepo.findById(id);
		if(schoolInfo.isPresent()) {
			School toUpdate=schoolInfo.get();
			toUpdate.setFinish_date(date);
			toUpdate.setSchool_name(schoolName);
			return schoolRepo.save(toUpdate);
		}else
		{
			return null;
		}
	}
	
	public void deleteSchool(int id,String schoolName) {
		Person person=personService.getPersonById(id);
		if(person!=null) {
			List<School> schools=schoolRepo.findByPersonId(id);
			for (School school : schools) {
				if(school.getSchool_name()== schoolName) {
					schoolRepo.delete(school);
				}
			}
		}
	}
}
