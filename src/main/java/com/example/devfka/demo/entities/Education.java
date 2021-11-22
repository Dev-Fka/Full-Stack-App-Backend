package com.example.devfka.demo.entities;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name="Education")
@Table(name="Education",uniqueConstraints = {@UniqueConstraint(columnNames = {"person_id","school_name"})})
public class Education {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="person_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	 private Person person;
	
	@Column(name="school_name",nullable = true)
	private String school_name;
	
	@Column(name="finish_date",nullable = true)
	@Temporal(TemporalType.DATE)
	private Date finish_date;

	
	
	public Education(int id, Person person, String school_name, Date finish_date) {
		super();
		this.id = id;
		this.person = person;
		this.school_name = school_name;
		this.finish_date = finish_date;
	}
	
	public Education() {
		
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
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public Date getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}
	
	
}
