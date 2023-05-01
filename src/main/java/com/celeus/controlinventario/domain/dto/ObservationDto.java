package com.celeus.controlinventario.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ObservationDto {
	
	private Long id;
	
	private String observationText;
	
	private UserDto userDto;
	
	private MaintenanceDto maintenanceDto;
}
