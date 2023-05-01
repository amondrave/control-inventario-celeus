package com.celeus.controlinventario.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActiveStatusDto {
	
	private Long id;
	
	private ActiveDto activeDto;
	
	private ActiveTypeDto activeTypeDto;
	
	private String observation;
}
