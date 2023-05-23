package com.celeus.controlinventario.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celeus.controlinventario.domain.dto.MaintenanceTypeDto;
import com.celeus.controlinventario.domain.service.MaintenanceTypeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/MaintenanceType")
class MaintenanceTypeController {
	
	private final MaintenanceTypeService maintenanceTypeService;

	public MaintenanceTypeController(MaintenanceTypeService maintenanceTypeService) {
		super();
		this.maintenanceTypeService = maintenanceTypeService;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<MaintenanceTypeDto>> getAll(){
		List<MaintenanceTypeDto> listMaintenanceTypeDtos = maintenanceTypeService.getAllMaintenanceType();
		return new ResponseEntity<List<MaintenanceTypeDto>>(listMaintenanceTypeDtos,HttpStatus.ACCEPTED);
	}

}
