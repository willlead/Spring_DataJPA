package com.example.demo.service;

import com.example.demo.domain.entity.Customer;

public interface CustomerService {
	public Customer createCustomer(Customer customer);
	public Customer getCustomerById(Long id);
}
