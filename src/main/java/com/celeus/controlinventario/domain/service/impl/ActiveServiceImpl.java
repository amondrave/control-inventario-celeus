package com.celeus.controlinventario.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.ActiveConnector;
import com.celeus.controlinventario.domain.dto.ActiveDto;
import com.celeus.controlinventario.domain.service.ActiveService;
import com.celeus.controlinventario.persistence.mapper.ActiveMapper;


@Service
public class ActiveServiceImpl implements ActiveService {
	
	private final ActiveConnector activeConnector;
	
	private final ActiveMapper activeMapper;
	
	

	public ActiveServiceImpl(ActiveConnector activeConnector, ActiveMapper activeMapper) {
		super();
		this.activeConnector = activeConnector;
		this.activeMapper = activeMapper;
	}

	@Override
	public List<ActiveDto> getAllActivesEnabled() {
		// TODO Auto-generated method stub
		List<ActiveDto> activeDtos = activeConnector.getAllActivesEnabled()
				.stream()
				.map(activo -> {
					ActiveDto activeDto = activeMapper.entityToDto(activo);
					return activeDto;
				})
				.collect(Collectors.toList());
		return activeDtos;
	}

	@Override
	public ActiveDto saveActive(ActiveDto activeDto) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public ActiveDto updateActive(ActiveDto activeDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActiveDto getActiveById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActiveDto getActiveByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enabledActive(Long id) {
		// TODO Auto-generated method stub
		
	}

}
