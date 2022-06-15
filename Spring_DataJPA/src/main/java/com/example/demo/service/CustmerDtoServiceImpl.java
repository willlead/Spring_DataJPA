package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Customer;
import com.example.demo.domain.entity.CustomerDto;
import com.example.demo.domain.repository.CustomerRepository;

@Service
public class CustmerDtoServiceImpl implements CustomerDtoService {

	@Autowired
	CustomerRepository repository;
	
	@Override
	public int createCustomer(CustomerDto customerDto) {
		Customer customer = Customer.builder().name(customerDto.getName()).address(customerDto.getAddress()).build();
		customer = repository.save(customer);
		if(customer.getId() > 1) {
			return 1;
		}
		return 0;
	}

}
