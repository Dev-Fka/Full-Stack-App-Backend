package com.example.devfka.demo.entities;

import java.util.*;

import javax.persistence.*;


@Entity(name="Person")
@Table(name="Persons")
public class Person {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="lastName",nullable = false)
	private String lastName;
	
	@Column(name="identityNumber",nullable=false,unique = true,length = 12)
	private String identityNumber;
	
	@Column(name="birthDate",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(name="bloodGroup",nullable=false)
	private String bloodGroup;

	public Person(Long id, String name, String lastName, String identityNumber, Date birthDate, String bloodGroup) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.identityNumber = identityNumber;
		this.birthDate = birthDate;
		this.bloodGroup = bloodGroup;
	}

	public Person() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
}
