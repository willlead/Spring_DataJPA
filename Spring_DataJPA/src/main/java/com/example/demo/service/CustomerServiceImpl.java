package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Customer;
import com.example.demo.domain.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repository;
	
	public CustomerServiceImpl(CustomerRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Customer createCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return repository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		return repository.findById(id).get();
	}

}
