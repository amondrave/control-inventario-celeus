package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.LeavingFormatDto;
import com.celeus.controlinventario.persistence.entity.LeavingFormat;

@Component
public class LeavingFormatMapper {
	
	private final ActiveStatusMapper activeStatusMapper;
	
	private final DeparmentMapper deparmentMapper;
	
	private final UserMapper userMapper;
	
	private final WorkerMapper workerMapper;

	public LeavingFormatMapper(ActiveStatusMapper activeStatusMapper, DeparmentMapper deparmentMapper,
			UserMapper userMapper, WorkerMapper workerMapper) {
		super();
		this.activeStatusMapper = activeStatusMapper;
		this.deparmentMapper = deparmentMapper;
		this.userMapper = userMapper;
		this.workerMapper = workerMapper;
	}

	public LeavingFormatDto entityToDto(LeavingFormat leavingFormat) {
		return LeavingFormatDto.builder()
				.id(leavingFormat.getId())
				.activeStatusDto(activeStatusMapper.entityToDto(leavingFormat.getActiveTStatus()))
				.deparmentDto(deparmentMapper.entityToDto(leavingFormat.getDeparment()))
				.userDto(userMapper.entityToDto(leavingFormat.getUser()))
				.workerDto(workerMapper.entityToDto(leavingFormat.getWorker()))
				.requestDate(leavingFormat.getDateRequest())
				.status(leavingFormat.getStatus())
				.reason(leavingFormat.getReason())
				.build();
	}
	
	public LeavingFormat dtoToEntity(LeavingFormatDto leavingFormatDto) {
		return LeavingFormat.builder()
				.id(leavingFormatDto.getId())
				.activeTStatus(activeStatusMapper.dtoToEntity(leavingFormatDto.getActiveStatusDto()))
				.deparment(deparmentMapper.dtoToEntity(leavingFormatDto.getDeparmentDto()))
				.user(userMapper.dtoToEntity(leavingFormatDto.getUserDto()))
				.worker(workerMapper.dtoToEntity(leavingFormatDto.getWorkerDto()))
				.dateRequest(leavingFormatDto.getRequestDate())
				.status(leavingFormatDto.getStatus())
				.reason(leavingFormatDto.getReason())
				.build();
	}
}

