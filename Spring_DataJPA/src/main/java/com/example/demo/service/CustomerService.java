package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.entity.Customer;

public interface CustomerService {
	
	public Customer createCustomer(Customer customer); 
	public List<Customer> getAllCustomer();
	public Customer getCustomerById(Long id);
}
