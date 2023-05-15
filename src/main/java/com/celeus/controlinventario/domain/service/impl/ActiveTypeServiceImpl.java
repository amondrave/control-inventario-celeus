 package com.celeus.controlinventario.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.ActiveTypeConnector;
import com.celeus.controlinventario.domain.dto.ActiveTypeDto;
import com.celeus.controlinventario.domain.service.ActiveTypeService;
import com.celeus.controlinventario.persistence.entity.ActiveType;
import com.celeus.controlinventario.persistence.mapper.ActiveTypeMapper;

@Service
public class ActiveTypeServiceImpl implements ActiveTypeService {
	
	private final ActiveTypeConnector activeTypeConnector;
	
	private final ActiveTypeMapper activeTypeMapper;
	
	

	public ActiveTypeServiceImpl(ActiveTypeConnector activeTypeConnector, ActiveTypeMapper activeTypeMapper) {
		super();
		this.activeTypeConnector = activeTypeConnector;
		this.activeTypeMapper = activeTypeMapper;
	}

	@Override
	public List<ActiveTypeDto> getAllActiveType() {
		// TODO Auto-generated method stub
		List<ActiveType> listMapper = activeTypeConnector.getAllActiveType();
		if(!listMapper.isEmpty())
			return mapperList(listMapper);
		return null;
	}
	
	private List<ActiveTypeDto> mapperList(List<ActiveType> listMapper){
		return listMapper.stream()
				.map(a -> {
					ActiveTypeDto activeTypeDto = activeTypeMapper.entityToDTo(a);
					return activeTypeDto;
				})
				.collect(Collectors.toList());
	}

	@Override
	public ActiveTypeDto getActiveTypeById(Long id) {
		// TODO Auto-generated method stub
		return activeTypeMapper.entityToDTo(activeTypeConnector.findActiveTypeById(id));
	}

}
