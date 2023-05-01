package com.celeus.controlinventario.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EvidenceDto {
	
	private Long id;
	
	private String evidenceUrl;
	
	private MaintenanceDto maintenanceDto;
	
	private UserDto userDto;

}
