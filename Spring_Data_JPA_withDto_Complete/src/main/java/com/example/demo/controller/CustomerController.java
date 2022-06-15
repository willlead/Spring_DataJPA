package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService service;
	
	@PostMapping("/customer")
	public int createCustomer(@RequestBody Customer customer) {
		if(service.createCustomer(customer) !=null) {
			return 1;
		};
		return 0;
	}
	//id를 이용하여 Customer를 조회하는 기능(API)을 개발하세요.^^(2시25분까지 ~~~)
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(Long id) {
		return service.getCustomerById(id);
	}	
	
}
