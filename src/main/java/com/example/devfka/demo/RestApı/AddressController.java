package com.example.devfka.demo.RestApı;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.devfka.demo.Service.AddressService;
import com.example.devfka.demo.entities.Address;

@RestController
@RequestMapping("/address")
public class AddressController {

	private AddressService _addressService;

	public AddressController(AddressService _addressService) {
		this._addressService = _addressService;
	}
	
	@GetMapping
	public List<Address> getAll(){
		return _addressService.getAll();
	}
	
	@GetMapping("/city/{place}")
	public List<Address> getByPlace(@PathVariable String place){
		return _addressService.getByAddressesDescription(place);
	}
	
	@GetMapping("/{id}")
	public Address getById(@PathVariable int id) {
		return _addressService.getByPersonId(id);
	}
	
	@PostMapping("/{id}")
	public Address saveAdress(@PathVariable int id, @RequestBody Address newAdress) {
		return _addressService.saveAddress(id,newAdress);
	}
	
	@PutMapping("/{id}")
	public Address updateAddress(@PathVariable int id,@RequestBody Address newAdress) {
		return _addressService.updateAddress(id,newAdress);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAddress(@PathVariable int id) {
		 _addressService.deleteAddress(id);
	}
}
