package com.celeus.controlinventario.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.celeus.controlinventario.domain.dto.MaintenanceDto;
import com.celeus.controlinventario.domain.service.MaintenanceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/maintenance")
public class MaintenanceController {
	
	private final MaintenanceService maintenanceService;

	public MaintenanceController(MaintenanceService maintenanceService) {
		super();
		this.maintenanceService = maintenanceService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<MaintenanceDto> create(@RequestPart("body") MaintenanceDto maintenanceDto, @RequestPart("images") MultipartFile[] images) throws IOException{
		MaintenanceDto response = maintenanceService.create(maintenanceDto, images);
		return new ResponseEntity<MaintenanceDto>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("find/{id}")
	public ResponseEntity<MaintenanceDto> getById(@PathVariable Long id){
		MaintenanceDto maintenanceDto = maintenanceService.getMaintenanceById(id);
		return new ResponseEntity<MaintenanceDto>(maintenanceDto,HttpStatus.OK);
	}
	
	@GetMapping("findAll/active/{idActive}")
	public ResponseEntity<List<MaintenanceDto>> getAllByActive(@PathVariable("idActive") Long idActive){
		List<MaintenanceDto> list = maintenanceService.getAllMaintenanceByActive(idActive);
		return new ResponseEntity<List<MaintenanceDto>>(list,HttpStatus.ACCEPTED);
	}
	
}
