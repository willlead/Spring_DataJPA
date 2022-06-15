package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Customer;
import com.example.demo.domain.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	//@Autowired //Field Injection
	private final CustomerRepository repository;
	
	
	//@Autowired //Constructor Injection
	public CustomerServiceImpl(CustomerRepository repository) {
		this.repository=repository;
	}
	
//	@Autowired //Setter Injection
//	public void setCustomerRepository(CustomerRepository repository) {
//		this.repository=repository;
//	}

	@Override
	public Customer createCustomer(Customer customer) {		
		return repository.save(customer);
	}

	@Override
	public Customer getCustomerById(Long id) {		
		return repository.findById(id).get();
	}
}
