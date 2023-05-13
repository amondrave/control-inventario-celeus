package com.celeus.controlinventario.domain.service;

import java.util.List;

import com.celeus.controlinventario.domain.dto.ActiveDto;

public interface ActiveService {
	
	List<ActiveDto> getAllActivesEnabled();

	ActiveDto saveActive(ActiveDto activeDto);
	
	ActiveDto updateActive(ActiveDto activeDto);
	
	ActiveDto getActiveById(Long id);
	
	ActiveDto getActiveByCode(String code);
	
	void enabledActive(Long id);
}
