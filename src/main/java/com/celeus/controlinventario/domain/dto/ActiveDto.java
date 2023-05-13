package com.celeus.controlinventario.domain.dto;


import java.time.LocalDateTime;

import com.celeus.controlinventario.persistence.entity.ActiveType;
import com.celeus.controlinventario.persistence.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
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
