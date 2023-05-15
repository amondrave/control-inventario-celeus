package com.celeus.controlinventario.domain.connector;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.dto.DeparmentDto;

@Repository
public interface DeparmentConnector {

	List<DeparmentDto> getAllDeparment();
	
	DeparmentDto getDeparmentById(Long id);
}
