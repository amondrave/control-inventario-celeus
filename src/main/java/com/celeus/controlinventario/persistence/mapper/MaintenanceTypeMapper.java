package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.MaintenanceTypeDto;
import com.celeus.controlinventario.persistence.entity.MaintenanceType;

@Component
public class MaintenanceTypeMapper {

	
	public MaintenanceTypeDto entityToDto(MaintenanceType maintenanceType) {
		return MaintenanceTypeDto.builder()
				.id(maintenanceType.getId())
				.description(maintenanceType.getDescription())
				.build();
	}
	
	public MaintenanceType dtoToEntity(MaintenanceTypeDto maintenanceTypeDto) {
		return MaintenanceType.builder()
				.id(maintenanceTypeDto.getId())
				.description(maintenanceTypeDto.getDescription())
				.build();
	}
	
}
