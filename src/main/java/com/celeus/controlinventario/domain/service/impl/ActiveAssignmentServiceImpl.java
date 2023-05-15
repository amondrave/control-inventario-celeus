package com.celeus.controlinventario.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.ActiveAssignmentConnector;
import com.celeus.controlinventario.domain.dto.ActiveAssignmentDto;
import com.celeus.controlinventario.domain.dto.ActiveDto;
import com.celeus.controlinventario.domain.dto.UserDto;
import com.celeus.controlinventario.domain.dto.WorkerDto;
import com.celeus.controlinventario.domain.service.ActiveAssignmentService;
import com.celeus.controlinventario.domain.service.ActiveService;
import com.celeus.controlinventario.domain.service.UserService;
import com.celeus.controlinventario.domain.service.WorkerService;
import com.celeus.controlinventario.persistence.entity.ActiveAssignment;
import com.celeus.controlinventario.persistence.mapper.ActiveAssignmentMapper;

@Service
public class ActiveAssignmentServiceImpl implements ActiveAssignmentService {
	
	private final ActiveAssignmentConnector activeAssignmentConnector;
	
	private final ActiveAssignmentMapper activeAssignmentMapper;
	
	private final WorkerService workerService;
	
	private final ActiveService activeService;
	
	private final UserService userService;
	
	
	
	

	public ActiveAssignmentServiceImpl(ActiveAssignmentConnector activeAssignmentConnector,
			ActiveAssignmentMapper activeAssignmentMapper, WorkerService workerService, ActiveService activeService,
			UserService userService) {
		super();
		this.activeAssignmentConnector = activeAssignmentConnector;
		this.activeAssignmentMapper = activeAssignmentMapper;
		this.workerService = workerService;
		this.activeService = activeService;
		this.userService = userService;
	}



	@Override
	public List<ActiveAssignmentDto> getAllActiveAssignment() {
		List<ActiveAssignment> list = activeAssignmentConnector.getAllActiveAssignment();
		if(!list.isEmpty())
			return this.mapperList(list);
		return null;
	}
	
	private List<ActiveAssignmentDto> mapperList(List<ActiveAssignment> list){
		return list.stream()
				.map(a -> {
					ActiveAssignmentDto activeAssignmentDto = activeAssignmentMapper.entityToDto(a);
					return activeAssignmentDto;
				})
				.collect(Collectors.toList());
	}

	@Override
	public List<ActiveAssignmentDto> getAllActiveAssignmentByActive(Long idActive) {
		// TODO Auto-generated method stub
		List<ActiveAssignment> list = activeAssignmentConnector.getAllActiveAssignmentByActive(idActive);
		if(!list.isEmpty())
			return this.mapperList(list);
		return null;
	}

	@Override
	public ActiveAssignmentDto createActiveAssignment(ActiveAssignmentDto activeAssignmentDto) {
		// TODO Auto-generated method stub
		WorkerDto workerDto = workerService.getWorkedById(activeAssignmentDto.getWorkerDto().getId());
		ActiveDto activeDto = activeService.getActiveById(activeAssignmentDto.getActiveDto().getId());
		UserDto userDto = userService.getUserById(activeAssignmentDto.getUserDto().getId());
		activeAssignmentDto.setUserDto(userDto);
		activeAssignmentDto.setActiveDto(activeDto);
		activeAssignmentDto.setWorkerDto(workerDto);
		System.out.println("DTO -->>>>>> "+activeAssignmentDto.toString());
		return activeAssignmentMapper.entityToDto(
				activeAssignmentConnector.createActiveAssignment(
						activeAssignmentMapper.dtoToEntity(activeAssignmentDto)));
	}

	@Override
	public ActiveAssignmentDto getActiveAssignmentById(Long id) {
		// TODO Auto-generated method stub
		return activeAssignmentMapper.entityToDto(activeAssignmentConnector.getActiveAssignmentById(id));
	}

	@Override
	public void deleteActiveAssignment(Long id) {
		// TODO Auto-generated method stub
		activeAssignmentConnector.deleteActiveAssignment(id);
		
	}

}
