package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Customer;
import com.example.demo.domain.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	//autowired 없어도 실행됨.
	@Autowired //Filed inejction  
	private final CustomerRepository repository;
	
	//Constructor injection 
	//생성자가 포함되고 repo를 넘기면 autowired를 대신하며 이 생성자를 만드는 방법을 권장한다.
	public CustomerServiceImpl(CustomerRepository repository) {
		this.repository = repository;
	}
	
//	@Autowired //setter injection
//	public void setCustomerRerpository(CustomerRepository repository) {
//		this.repository = repository;
//	}
	
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
