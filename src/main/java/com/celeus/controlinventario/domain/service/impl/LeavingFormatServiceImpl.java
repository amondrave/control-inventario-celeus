package com.celeus.controlinventario.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.LeavingFormatConnector;
import com.celeus.controlinventario.domain.dto.LeavingFormatDto;
import com.celeus.controlinventario.domain.service.ActiveStatusService;
import com.celeus.controlinventario.domain.service.DeparmentService;
import com.celeus.controlinventario.domain.service.LeavingFormatService;
import com.celeus.controlinventario.domain.service.UserService;
import com.celeus.controlinventario.domain.service.WorkerService;
import com.celeus.controlinventario.persistence.entity.LeavingFormat;
import com.celeus.controlinventario.persistence.mapper.LeavingFormatMapper;

@Service
public class LeavingFormatServiceImpl implements LeavingFormatService{
	
			
	private final LeavingFormatConnector leavingFormatConnector;
	
	private final LeavingFormatMapper leavingFormatMapper;
	
	private final UserService userService;
	
	private final WorkerService workerService;
	
	private final DeparmentService deparmentService;
	
	private final ActiveStatusService activeStatusService;
	
		
	
	public LeavingFormatServiceImpl(LeavingFormatConnector leavingFormatConnector,
			LeavingFormatMapper leavingFormatMapper, UserService userService, WorkerService workerService,
			DeparmentService deparmentService, ActiveStatusService activeStatusService) {
		super();
		this.leavingFormatConnector = leavingFormatConnector;
		this.leavingFormatMapper = leavingFormatMapper;
		this.userService = userService;
		this.workerService = workerService;
		this.deparmentService = deparmentService;
		this.activeStatusService = activeStatusService;
	}

	@Override
	public List<LeavingFormatDto> getAllLeavingFormat() {
		// TODO Auto-generated method stub
		List<LeavingFormat> list = leavingFormatConnector.getAllLeavingFormat();
		if(!list.isEmpty())
			return mapperList(list);
		return null;
	}

	@Override
	public List<LeavingFormatDto> getAllLeavingFormatByActiveId(Long idActive) {
		// TODO Auto-generated method stub
		List<LeavingFormat> list = leavingFormatConnector.getAllLeavingFormatByActiveId(idActive);
		if(!list.isEmpty())
			return mapperList(list);
		return null;
	}
	
	private List<LeavingFormatDto> mapperList(List<LeavingFormat> list){
		return list.stream()
				.map(l -> {
					LeavingFormatDto leavingFormatDto = leavingFormatMapper.entityToDto(l);
					return leavingFormatDto;
				})
				.collect(Collectors.toList());
	}

	@Override
	public LeavingFormatDto createLeavingFormat(LeavingFormatDto leavingFormatDto) {
		// TODO Auto-generated method stub
		leavingFormatDto.setUserDto(userService.getUserById(leavingFormatDto.getUserDto().getId()));
		leavingFormatDto.setActiveStatusDto(activeStatusService.getActiveStatusById(leavingFormatDto.getActiveStatusDto().getId()));
		leavingFormatDto.setDeparmentDto(deparmentService.getDeparmentById(leavingFormatDto.getDeparmentDto().getId()));
		leavingFormatDto.setWorkerDto(workerService.getWorkedById(leavingFormatDto.getWorkerDto().getId()));
		LeavingFormat leavingFormat = leavingFormatMapper.dtoToEntity(leavingFormatDto);
		return leavingFormatMapper.entityToDto(leavingFormatConnector.createLeavingFormat(leavingFormat));
	}

	@Override
	public LeavingFormatDto getLeavingFormatDtoById(Long id) {
		// TODO Auto-generated method stub
		return leavingFormatMapper.entityToDto(leavingFormatConnector.getLeavingFormatById(id));
	}

}
