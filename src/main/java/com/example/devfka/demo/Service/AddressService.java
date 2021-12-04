package com.example.devfka.demo.Service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.devfka.demo.DataAccess.AddressRepo;
import com.example.devfka.demo.entities.Address;
import com.example.devfka.demo.entities.Person;

@Service
public class AddressService {
	
	AddressRepo addressRepo;
	PersonService _personService;
	
	public AddressService(AddressRepo addressRepo,PersonService personService) {
		this.addressRepo=addressRepo;
		this._personService=personService;
	}
	
	
	public List<Address> getAll(){
		
		return addressRepo.findAll();
	}
	
	public List<Address> getByAddressesDescription(String place){
		List<Address> addresses= addressRepo.findByDescriptionContaining(place);
		if(addresses.isEmpty()) {
			return null;
		}else {
			return addresses;
		}
	}
	
	public Address getByPersonId(int id) {
		Address address=addressRepo.findByPersonId(id);
			return address;
	}
	
	
	
	public Address saveAddress (int id,Address newAdress) {
			Person person=_personService.getPersonById(id);
			if(person!=null && addressRepo.findByPersonId(person.getId())==null) {
					Address addNewAddress=new Address();
					addNewAddress.setPerson(person);
					addNewAddress.setDescription(newAdress.getDescription());
					addressRepo.save(addNewAddress);
					return addNewAddress;
			}else {
				return null;
			}
	}
	
	public Address updateAddress(int id,Address newAdress) {
		Person person=_personService.getPersonById(id);
		if(person!=null && addressRepo.findByPersonId(person.getId())!=null) {
			Address address=addressRepo.findByPersonId(person.getId());
			address.setDescription(newAdress.getDescription());
			address.setPerson(person);
			addressRepo.save(address);
			return address;
		}else {
			return null;
		}
	}
	
	public void deleteAddress(int id) {
		Person person=_personService.getPersonById(id);
		if(person!=null && addressRepo.findByPersonId(person.getId())!=null) {
			Address addressForDelete=addressRepo.findByPersonId(person.getId());
			addressRepo.delete(addressForDelete);
		}	
	}
	
	
}
