package com.example.devfka.demo.RestApı;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/save")
	public Address saveAdress(@RequestBody String identyNumber,String description) {
		return _addressService.saveAddress(identyNumber,description);
	}
	
	@PostMapping("/update/{description}")
	public Address updateAddress(@PathVariable String description,@RequestBody String identyNumber) {
		return _addressService.updateAddress(identyNumber, description);
	}
	
	@PostMapping("/delete")
	public void deleteAddress(@RequestBody String identyNumber) {
		 _addressService.deleteAddress(identyNumber);
	}
}
