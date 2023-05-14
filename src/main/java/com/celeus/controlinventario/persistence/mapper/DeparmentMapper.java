package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.DeparmentDto;
import com.celeus.controlinventario.persistence.entity.Deparment;

@Component
public class DeparmentMapper {

	
	public DeparmentDto entityToDto(Deparment deparment) {
		return DeparmentDto.builder()
				.id(deparment.getId())
				.name(deparment.getName())
				.build();
	}
	
	public Deparment dtoToEntity(DeparmentDto deparmentDto) {
		return Deparment.builder()
				.id(deparmentDto.getId())
				.name(deparmentDto.getName())
				.build();
	}
	
}
