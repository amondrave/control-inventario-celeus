package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.MaintenanceDto;
import com.celeus.controlinventario.persistence.entity.Maintenance;

@Component
public class MaintenanceMapper {
	
	private final UserMapper userMapper;
	
	private final ActiveMapper activeMapper;
	
	private final MaintenanceTypeMapper maintenanceTypeMapper;
	
	

	public MaintenanceMapper(UserMapper userMapper, ActiveMapper activeMapper,
			MaintenanceTypeMapper maintenanceTypeMapper) {
		super();
		this.userMapper = userMapper;
		this.activeMapper = activeMapper;
		this.maintenanceTypeMapper = maintenanceTypeMapper;
	}



	public MaintenanceDto entityToDto(Maintenance maintenance) {
		return MaintenanceDto.builder()
				.activeDto(activeMapper.entityToDto(maintenance.getActive()))
				.id(maintenance.getId())
				.maintenanceTypeDto(maintenanceTypeMapper.entityToDto(maintenance.getMaintenanceType()))
				.userDto(userMapper.entityToDto(maintenance.getUser()))
				.createdDate(maintenance.getCreatedDate())
				.build();
	}
	
	public Maintenance dtoToEntity(MaintenanceDto maintenanceDto) {
		return Maintenance.builder()
				.id(maintenanceDto.getId())
				.active(activeMapper.dtoToEntity(maintenanceDto.getActiveDto()))
				.maintenanceType(maintenanceTypeMapper.dtoToEntity(maintenanceDto.getMaintenanceTypeDto()))
				.user(userMapper.dtoToEntity(maintenanceDto.getUserDto()))
				.build();
	}
	
}
