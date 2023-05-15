package com.celeus.controlinventario.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.ActiveStatusConnector;
import com.celeus.controlinventario.domain.dto.ActiveStatusDto;
import com.celeus.controlinventario.domain.service.ActiveStatusService;
import com.celeus.controlinventario.persistence.mapper.ActiveStatusMapper;



@Service
public class ActiveStatusServiceImpl implements ActiveStatusService{
	
	private final ActiveStatusConnector activeStatusConnector;
	
	private final ActiveStatusMapper activeStatusMapper;
	
	

	public ActiveStatusServiceImpl(ActiveStatusConnector activeStatusConnector, ActiveStatusMapper activeStatusMapper) {
		super();
		this.activeStatusConnector = activeStatusConnector;
		this.activeStatusMapper = activeStatusMapper;
	}

	@Override
	public List<ActiveStatusDto> getAllActiveStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActiveStatusDto> getAllActiveStatusByActive(Long idActive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActiveStatusDto createActiveStatus(ActiveStatusDto ActiveStatusDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteACtiveStatus(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActiveStatusDto getActiveStatusById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
