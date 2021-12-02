package com.example.devfka.demo.RestApı;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/save")
	public School saveSchool(@RequestBody int id,Date date,String schoolName) {
		return schoolService.saveSchool(id,date,schoolName);
	}
	
	@PostMapping("/update")
	public School updateSchool(@RequestBody int id,Date date,String schoolName) {
		return schoolService.updateOneSchool(id,date,schoolName);
	}
	
	@PostMapping("/delete")
	public void deleteSchool(@RequestBody int id,String schoolName) {
		schoolService.deleteSchool(id, schoolName);
	}
}
