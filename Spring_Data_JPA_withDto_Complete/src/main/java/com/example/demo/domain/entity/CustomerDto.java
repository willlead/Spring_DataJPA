package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CustomerDto {	
	private String name;
	private String address;
}
