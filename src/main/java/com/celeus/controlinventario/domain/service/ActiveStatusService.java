package com.celeus.controlinventario.domain.service;

import java.util.List;

import com.celeus.controlinventario.domain.dto.ActiveStatusDto;

public interface ActiveStatusService {
	
	List<ActiveStatusDto> getAllActiveStatus();
	
	List<ActiveStatusDto> getAllActiveStatusByActive(Long idActive);
	
	List<ActiveStatusDto> getByActiveTypeStatus();
	
	ActiveStatusDto createActiveStatus(ActiveStatusDto ActiveStatusDto);
	
	void deleteACtiveStatus(Long id);
	
	ActiveStatusDto getActiveStatusById(Long id);

}
