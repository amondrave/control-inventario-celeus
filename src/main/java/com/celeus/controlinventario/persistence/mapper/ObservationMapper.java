package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.ObservationDto;
import com.celeus.controlinventario.persistence.entity.Observation;

@Component
public class ObservationMapper {
	
	private final UserMapper userMapper;
	
	private final MaintenanceMapper maintenanceMapper;

	public ObservationMapper(UserMapper userMapper, MaintenanceMapper maintenanceMapper) {
		super();
		this.userMapper = userMapper;
		this.maintenanceMapper = maintenanceMapper;
	}
	
	
	public ObservationDto entityToDto(Observation observation) {
		return ObservationDto.builder()
				.id(observation.getId())
				.observationText(observation.getObservationText())
				.maintenanceDto(maintenanceMapper.entityToDto(observation.getMaintenance()))
				.userDto(userMapper.entityToDto(observation.getUser()))
				.build();
	}
	
	public Observation dtoToEntity(ObservationDto observationDto) {
		return Observation.builder()
				.id(observationDto.getId())
				.observationText(observationDto.getObservationText())
				.maintenance(maintenanceMapper.dtoToEntity(observationDto.getMaintenanceDto()))
				.user(userMapper.dtoToEntity(observationDto.getUserDto()))
				.build();
	}

}
