package com.celeus.controlinventario.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.ActiveStatusConnector;
import com.celeus.controlinventario.domain.dto.ActiveStatusDto;
import com.celeus.controlinventario.domain.service.ActiveService;
import com.celeus.controlinventario.domain.service.ActiveStatusService;
import com.celeus.controlinventario.domain.service.ActiveTypeStatusService;
import com.celeus.controlinventario.persistence.entity.ActiveStatus;
import com.celeus.controlinventario.persistence.mapper.ActiveStatusMapper;



@Service
public class ActiveStatusServiceImpl implements ActiveStatusService{
	
	private final ActiveStatusConnector activeStatusConnector;
	
	private final ActiveStatusMapper activeStatusMapper;
	
	private final ActiveService activeService;
	
	private final ActiveTypeStatusService activeTypeStatusService;
	
	

	public ActiveStatusServiceImpl(ActiveStatusConnector activeStatusConnector, ActiveStatusMapper activeStatusMapper,
			ActiveService activeService,ActiveTypeStatusService activeTypeStatusService ) {
		super();
		this.activeStatusConnector = activeStatusConnector;
		this.activeStatusMapper = activeStatusMapper;
		this.activeService = activeService;
		this.activeTypeStatusService = activeTypeStatusService;
	}

	@Override
	public List<ActiveStatusDto> getAllActiveStatus() {
		List<ActiveStatus> list = activeStatusConnector.getAllActiveStatus();
		if( list != null && !list.isEmpty())
			return mapperList(list);
		return null;
	}

	@Override
	public List<ActiveStatusDto> getAllActiveStatusByActive(Long idActive) {
		List<ActiveStatus> list = activeStatusConnector.getAllActiveStatusByActive(idActive);
		if( list != null && !list.isEmpty())
			return mapperList(list);
		return null;
	}
	
	private List<ActiveStatusDto> mapperList(List<ActiveStatus> list){
		return list.stream()
				.map( ac -> {
					ActiveStatusDto activeStatusDto = activeStatusMapper.entityToDto(ac);
					return activeStatusDto;
				})
				.collect(Collectors.toList());
	}

	@Override
	public ActiveStatusDto createActiveStatus(ActiveStatusDto ActiveStatusDto) {
		// TODO Auto-generated method stub
		ActiveStatusDto.setActiveDto(activeService.getActiveById(ActiveStatusDto.getActiveDto().getId()));
		ActiveStatusDto.setActiveTypeStatusDto(activeTypeStatusService.getActiveTypeStatusById(ActiveStatusDto.getActiveTypeStatusDto().getId()));
		ActiveStatus ActiveStatus = activeStatusMapper.dtoToEntity(ActiveStatusDto);
		return activeStatusMapper.entityToDto(activeStatusConnector.createActiveStatus(ActiveStatus));
	}

	@Override
	public void deleteACtiveStatus(Long id) {
		activeStatusConnector.deleteActiveStatus(id);
	}

	@Override
	public ActiveStatusDto getActiveStatusById(Long id) {
		return activeStatusMapper.entityToDto(activeStatusConnector.getActiveStatusById(id));
	}

	@Override
	public List<ActiveStatusDto> getByActiveTypeStatus() {
		// TODO Auto-generated method stub
		List<ActiveStatus> list = activeStatusConnector.getByActiveTypeStatus();
		if( list != null && !list.isEmpty())
			return mapperList(list);
		return null;
	}

}
