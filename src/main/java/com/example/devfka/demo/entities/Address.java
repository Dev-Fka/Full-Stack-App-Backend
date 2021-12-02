package com.example.devfka.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity(name="Address")
@Table(name="Addresses",uniqueConstraints = {@UniqueConstraint(columnNames = {"description","personId"})})
public class Address {


	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="personId",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Person person;
	
	@Column(name="description")
	private String description;

	public Address(int id, Person person, String description) {
		super();
		this.id = id;
		this.person = person;
		this.description = description;
	}
	
	
	public Address() {
		
	}
	
	public int getAdress_id() {
		return id;
	}
	public void setAdress_id(int adress_id) {
		this.id = adress_id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
