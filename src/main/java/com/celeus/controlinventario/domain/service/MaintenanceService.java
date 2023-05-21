package com.celeus.controlinventario.domain.service;

import java.util.List;

import com.celeus.controlinventario.domain.dto.MaintenanceDto;

public interface MaintenanceService {
	
	MaintenanceDto create(MaintenanceDto maintenanceDto);
	
	MaintenanceDto getMaintenanceById(Long id);
	
	List<MaintenanceDto> getAllMaintenanceByActive(Long idActive);
	
	void delete(Long id);

}
