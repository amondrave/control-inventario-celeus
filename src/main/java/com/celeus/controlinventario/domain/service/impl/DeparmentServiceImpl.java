package com.celeus.controlinventario.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.DeparmentConnector;
import com.celeus.controlinventario.domain.dto.DeparmentDto;
import com.celeus.controlinventario.domain.service.DeparmentService;

@Service
public class DeparmentServiceImpl implements DeparmentService {
	
	private final DeparmentConnector deparmentConnector;
	
	

	public DeparmentServiceImpl(DeparmentConnector deparmentConnector) {
		super();
		this.deparmentConnector = deparmentConnector;
	}



	@Override
	public List<DeparmentDto> getAllDeparment() {
		// TODO Auto-generated method stub
		return deparmentConnector.getAllDeparment();
	}

}
