package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.entity.Customer;
import com.example.demo.domain.entity.CustomerDto;
import com.example.demo.domain.repository.CustomerRepository;

@Service
public class CustmerDtoServiceImpl implements CustomerDtoService {

	@Autowired
	CustomerRepository repository;
	
	@Autowired
	RestTemplate restTemplate; // 동기
	
//	WebClient client; //동기, 비동기 모두 지원
	//OpenFeign 
 	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Override
	public int createCustomer(CustomerDto customerDto) {
		//1. Dto -> Entity 변환
//		Customer customer = Customer.builder().name(customerDto.getName()).address(customerDto.getAddress()).build();
		
		//2. Dto -> Entity 변환
		Customer customer = Customer.builder().build();
		BeanUtils.copyProperties(customerDto, customer);
		
		//3. Dto -> Entity 변환 라이브러: ModelMapper, MapStruct ...
		
		customer = repository.save(customer);
		if(customer.getId() > 0) {
			return 1;
		}
		return 0;
	}
	
	public boolean isExistCustomer(Long id)
	{
		return repository.findById(id).isPresent();
	}

	@Override
	public CustomerDto getCustomerById2(Long id) {
		CustomerDto dto = CustomerDto.builder().build();
		if(isExistCustomer(id)) {
			Optional<Customer> optional = repository.findById(id);
			BeanUtils.copyProperties(optional.get(), dto, "id");
		}
		return dto;
	}

	@Override
	public CustomerDto getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String callApi() {
		return restTemplate.getForObject("http://localhost:8080/hi", String.class);
	}

}
