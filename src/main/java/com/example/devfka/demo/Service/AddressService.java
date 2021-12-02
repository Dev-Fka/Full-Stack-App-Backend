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
	
	
	
	public Address saveAddress (String identyNumber,String description) {
			Person person=_personService.getByPersonIdentyNum(identyNumber);
			if(person!=null) {
				Address address=new Address();
				address.setDescription(description);
				address.setPerson(person);
				address.setPerson(person);
				addressRepo.save(address);
				return address;
			}else {
				return null;
			}
	}
	
	public Address updateAddress(String description,String identyNum) {
		Person person=_personService.getByPersonIdentyNum(identyNum);
		if(person!=null) {
			Address address=addressRepo.findByPersonId(person.getId());
			address.setDescription(description);
			addressRepo.save(address);
			return address;
		}else {
			return null;
		}
	}
	
	public void deleteAddress(String identyNum) {
		Person person=_personService.getByPersonIdentyNum(identyNum);
			Address addressForDelete=addressRepo.findByPersonId(person.getId());
			addressRepo.delete(addressForDelete);
			
	}
	
	
}
