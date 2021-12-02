package com.example.devfka.demo.entities;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name="School")
@Table(name="School",uniqueConstraints = {@UniqueConstraint(columnNames = {"personId","schoolName"})})
public class School {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="personId",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	 private Person person;
	
	@Column(name="schoolName",nullable = true)
	private String schoolName;
	
	@Column(name="finishDate",nullable = true)
	@Temporal(TemporalType.DATE)
	private Date finishDate;

	
	
	public School(int id, Person person, String school_name, Date finish_date) {
		super();
		this.id = id;
		this.person = person;
		this.schoolName = school_name;
		this.finishDate = finish_date;
	}
	
	public School() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getSchool_name() {
		return schoolName;
	}

	public void setSchool_name(String school_name) {
		this.schoolName = school_name;
	}

	public Date getFinish_date() {
		return finishDate;
	}

	public void setFinish_date(Date finish_date) {
		this.finishDate = finish_date;
	}
	
	
}
