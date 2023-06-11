package com.celeus.controlinventario.domain.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.celeus.controlinventario.domain.dto.MaintenanceDto;

public interface MaintenanceService {
	
	void create(MaintenanceDto maintenanceDto, MultipartFile[] images)  throws IOException;
	
	MaintenanceDto getMaintenanceById(Long id);
	
	List<MaintenanceDto> getAllMaintenanceByActive(Long idActive);
	
	void delete(Long id);

}
