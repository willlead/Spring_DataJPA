package com.example.demo.service;

import com.example.demo.domain.entity.CustomerDto;

public interface CustomerDtoService {
	public int createCustomer(CustomerDto customerDto);
	public CustomerDto findCustomerById(Long id);
	public String callApi();
}
