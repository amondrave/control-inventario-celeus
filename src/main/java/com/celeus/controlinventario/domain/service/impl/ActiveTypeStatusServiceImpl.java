package com.celeus.controlinventario.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.ActiveTypeStatusConnector;
import com.celeus.controlinventario.domain.dto.ActiveTypeStatusDto;
import com.celeus.controlinventario.domain.service.ActiveTypeStatusService;
import com.celeus.controlinventario.persistence.entity.ActiveTypeStatus;
import com.celeus.controlinventario.persistence.mapper.ActiveTypeStatusMapper;

@Service
public class ActiveTypeStatusServiceImpl implements ActiveTypeStatusService {
	
	private final ActiveTypeStatusConnector activeTypeStatusConnector;
	
	private final ActiveTypeStatusMapper activeTypeStatusMapper;
	
	

	public ActiveTypeStatusServiceImpl(ActiveTypeStatusConnector activeTypeStatusConnector,
			ActiveTypeStatusMapper activeTypeStatusMapper) {
		super();
		this.activeTypeStatusConnector = activeTypeStatusConnector;
		this.activeTypeStatusMapper = activeTypeStatusMapper;
	}



	@Override
	public List<ActiveTypeStatusDto> getAllActiveTypeStatus() {
		// TODO Auto-generated method stub
		List<ActiveTypeStatus> listActiveStatusType = activeTypeStatusConnector.getAllActiveTypeStatus();
		if(!listActiveStatusType.isEmpty())
			return this.mapperList(listActiveStatusType);
		return null;
	}
	
	private List<ActiveTypeStatusDto> mapperList(List<ActiveTypeStatus> listActiveStatusType){
		return listActiveStatusType.stream()
				.map(a ->{
					ActiveTypeStatusDto adto = activeTypeStatusMapper.entityToDto(a);
					return adto;
				})
				.collect(Collectors.toList());
	}



	@Override
	public ActiveTypeStatusDto getActiveTypeStatusById(Long id) {
		// TODO Auto-generated method stub
		return activeTypeStatusMapper.entityToDto(activeTypeStatusConnector.getActiveTypeStatusById(id));
	}

}
