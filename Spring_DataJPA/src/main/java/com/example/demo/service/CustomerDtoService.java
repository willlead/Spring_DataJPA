package com.example.demo.service;

import com.example.demo.domain.entity.Customer;
import com.example.demo.domain.entity.CustomerDto;

public interface CustomerDtoService {
	public int createCustomer(CustomerDto customerDto);
	public CustomerDto getCustomerById(Long id);
	CustomerDto getCustomerById2(Long id);
	public String callApi();

}
