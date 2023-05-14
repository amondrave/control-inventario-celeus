package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.ActiveTypeStatusDto;
import com.celeus.controlinventario.persistence.entity.ActiveTypeStatus;

@Component
public class ActiveTypeStatusMapper {

	public ActiveTypeStatusDto entityToDto(ActiveTypeStatus activeTypeStatus) {
		return ActiveTypeStatusDto.builder()
				.id(activeTypeStatus.getId())
				.description(activeTypeStatus.getDescription())
				.build();
	}
	
	
	public ActiveTypeStatus dtoToEntity(ActiveTypeStatusDto activeTypeStatusDto) {
		return ActiveTypeStatus.builder()
				.id(activeTypeStatusDto.getId())
				.description(activeTypeStatusDto.getDescription())
				.build();
	}
	
}
