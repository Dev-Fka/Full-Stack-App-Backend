package com.example.devfka.demo.DataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.devfka.demo.entities.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer>{
	

	List<Address> findByDescriptionContaining(String description);
	
	Address findByPersonId(int id);
}
