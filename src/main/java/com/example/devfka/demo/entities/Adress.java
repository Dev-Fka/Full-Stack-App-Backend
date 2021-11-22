package com.example.devfka.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity(name="Address")
@Table(name="Addresses",uniqueConstraints = {@UniqueConstraint(columnNames = {"description","person_id"})})
public class Adress {


	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="person_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Person person;
	
	@Column(name="description")
	private String description;

	public Adress(int id, Person person, String description) {
		super();
		this.id = id;
		this.person = person;
		this.description = description;
	}
	
	
	public Adress() {
		
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
