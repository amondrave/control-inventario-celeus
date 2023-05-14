package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.EvidenceDto;
import com.celeus.controlinventario.persistence.entity.Evidence;

@Component
public class EvidenceMapper {
	
	private final UserMapper userMapper;
	
	private final MaintenanceMapper maintenanceMapper;

	public EvidenceMapper(UserMapper userMapper, MaintenanceMapper maintenanceMapper) {
		super();
		this.userMapper = userMapper;
		this.maintenanceMapper = maintenanceMapper;
	}
	
	public EvidenceDto entityToDto(Evidence evidence) {
		return EvidenceDto.builder()
				.id(evidence.getId())
				.evidenceUrl(evidence.getEvidenceUrl())
				.maintenanceDto(maintenanceMapper.entityToDto(evidence.getMaintenance()))
				.userDto(userMapper.entityToDto(evidence.getUser()))
				.build();
	}
	
	
	public Evidence dtoToEntity(EvidenceDto evidenceDto) {
		return Evidence.builder()
				.id(evidenceDto.getId())
				.evidenceUrl(evidenceDto.getEvidenceUrl())
				.maintenance(maintenanceMapper.dtoToEntity(evidenceDto.getMaintenanceDto()))
				.user(userMapper.dtoToEntity(evidenceDto.getUserDto()))
				.build();
	}
	
	

}
