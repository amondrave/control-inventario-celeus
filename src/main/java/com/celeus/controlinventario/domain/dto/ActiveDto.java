package com.celeus.controlinventario.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActiveDto {
	
	private Long id;
	
	private ActiveTypeDto activeTypeDto;
	
	
	private String name;
	

	private String serial;
	
	
	private String characteristic;
	

	private Integer quantity;
	
	
	private String yearAcquired;
	
	
	private Double value;
	

	private String code;
	
	
	private String image;
	
	
	private UserDto userDto;
	
	
	private Boolean enabled;
	
}
