package com.celeus.controlinventario.domain.service;

import java.util.List;

import com.celeus.controlinventario.domain.dto.ActiveTypeDto;

public interface ActiveTypeService {
	
	List<ActiveTypeDto> getAllActiveType();
	
	ActiveTypeDto getActiveTypeById(Long id);

}
