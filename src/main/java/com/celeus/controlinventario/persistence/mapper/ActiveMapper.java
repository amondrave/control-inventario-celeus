package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.ActiveDto;
import com.celeus.controlinventario.persistence.entity.Active;

@Component
public class ActiveMapper {
	
	private final UserMapper userMapper;
	
	private final ActiveTypeMapper activeTypeMapper;

	public ActiveMapper(UserMapper userMapper, ActiveTypeMapper activeTypeMapper) {
		super();
		this.userMapper = userMapper;
		this.activeTypeMapper = activeTypeMapper;
	}
	
	public ActiveDto entityToDto(Active active) {
		return ActiveDto.builder()
				.id(active.getId())
				.activeTypeDto(activeTypeMapper.entityToDTo(active.getActiveType()))
				.name(active.getName())
				.serial(active.getSerial())
				.characteristic(active.getCharacteristic())
				.quantity(active.getQuantity())
				.yearAcquired(active.getYearAcquired())
				.value(active.getValue())
				.code(active.getCode())
				.userDto(userMapper.entityToDto(active.getUser()))
				.enabled(active.getEnabled())
				.build();
	}
	
	
	public Active dtoToEntity(ActiveDto activeDto) {
		return Active.builder()
				.id(activeDto.getId())
				.activeType(activeTypeMapper.dtoToEntity(activeDto.getActiveTypeDto()))
				.name(activeDto.getName())
				.serial(activeDto.getSerial())
				.characteristic(activeDto.getCharacteristic())
				.quantity(activeDto.getQuantity())
				.yearAcquired(activeDto.getYearAcquired())
				.value(activeDto.getValue())
				.code(activeDto.getCode())
				.user(userMapper.dtoToEntity(activeDto.getUserDto()))
				.enabled(activeDto.getEnabled())
				.build();
	}

}
