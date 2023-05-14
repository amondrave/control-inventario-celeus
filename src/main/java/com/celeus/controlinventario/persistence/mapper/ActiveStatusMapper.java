package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.ActiveStatusDto;
import com.celeus.controlinventario.persistence.entity.ActiveStatus;


@Component
public class ActiveStatusMapper {

	private final ActiveMapper activeMapper;
	private final ActiveTypeStatusMapper activeTypeStatusMapper;

	public ActiveStatusMapper(ActiveMapper activeMapper, ActiveTypeStatusMapper activeTypeStatusMapper) {
		this.activeMapper = activeMapper;
		this.activeTypeStatusMapper = activeTypeStatusMapper;
	}

	public ActiveStatusDto entityToDto(ActiveStatus activeStatus) {
		return ActiveStatusDto.builder()
				.id(activeStatus.getId())
				.activeDto(activeMapper.entityToDto(activeStatus.getActive()))
				.activeTypeStatusDto(activeTypeStatusMapper.entityToDto(activeStatus.getActiveTypeStatus()))
				.observation(activeStatus.getObservation())
				.build();
	}

	public ActiveStatus dtoToEntity(ActiveStatusDto activeStatusDto) {
		return ActiveStatus.builder()
				.id(activeStatusDto.getId())
				.active(activeMapper.dtoToEntity(activeStatusDto.getActiveDto()))
				.activeTypeStatus(activeTypeStatusMapper.dtoToEntity(activeStatusDto.getActiveTypeStatusDto()))
				.observation(activeStatusDto.getObservation())
				.build();
	}

}
