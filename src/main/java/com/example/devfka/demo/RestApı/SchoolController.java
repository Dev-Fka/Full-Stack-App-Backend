package com.example.devfka.demo.RestApı;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.devfka.demo.Service.SchoolService;
import com.example.devfka.demo.entities.School;

@RestController
@RequestMapping("/school")
public class SchoolController {

	private SchoolService schoolService;

	public SchoolController(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
	
	@GetMapping
	public List<School> getAll(){
		return schoolService.getAll();
	}
	
	@GetMapping("/{id}")
	public List<School> getByPersonId(@PathVariable int id){
		return schoolService.getByPersonId(id);
	}
	
	@GetMapping("/name/{schoolName}")
	public List<School> getBySchoolName(@PathVariable String schoolName){
		return schoolService.getBySchoolName(schoolName);
	}
	
	@PostMapping("/{id}")
	public School saveSchool(@PathVariable int id,@RequestBody School newSchool) {
		return schoolService.saveSchool(id,newSchool);
	}
	
	@PutMapping("/{id}")
	public School updateSchool(@PathVariable int id ,@RequestBody School newSchool) {
		return schoolService.updateOneSchool(id,newSchool);
	}
	
	@DeleteMapping("/{id}")
	public void deleteSchool(@PathVariable int id) {
		schoolService.deleteSchool(id);
	}
}
