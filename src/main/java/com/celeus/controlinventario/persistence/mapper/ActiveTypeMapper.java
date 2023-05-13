package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.ActiveTypeDto;
import com.celeus.controlinventario.persistence.entity.ActiveType;

@Component
public class ActiveTypeMapper {

	
	public ActiveTypeDto entityToDTo(ActiveType activeType) {
		return ActiveTypeDto.builder()
				.id(activeType.getId())
				.sigle(activeType.getSigle())
				.type(activeType.getType())
				.build();
	}
	
	public ActiveType dtoToEntity(ActiveTypeDto activeTypeDto) {
		return ActiveType.builder()
				.id(activeTypeDto.getId())
				.sigle(activeTypeDto.getSigle())
				.type(activeTypeDto.getType())
				.build();
	}
}
