package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.entity.CustomerDto;
import com.example.demo.service.CustomerDtoService;

@RestController
public class CustomerDtoController {
	@Autowired
	CustomerDtoService service;

	
	@PostMapping("api/customer")
	public int createCustomer(@RequestBody CustomerDto customerDto) {
		return service.createCustomer(customerDto);
	}
	
	@GetMapping("api/customer/{id}")
	public CustomerDto getCustomer(@PathVariable Long id) {
		return service.getCustomerById(id);
	}
	
	@GetMapping("api/hi")
	public String callApi() {
		return service.callApi();
	}
	

}
