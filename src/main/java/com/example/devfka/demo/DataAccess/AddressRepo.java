package com.example.devfka.demo.DataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devfka.demo.entities.Address;

public interface AddressRepo extends JpaRepository<Address,Integer>{
	
	//List for want specific address
	
	List<Address> findByDescriptionContaining(String description);
	
	List<Address> findByPersonId(Long personId);
}
