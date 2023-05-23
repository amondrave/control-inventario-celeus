package com.celeus.controlinventario.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celeus.controlinventario.domain.dto.ActiveTypeStatusDto;
import com.celeus.controlinventario.domain.service.ActiveTypeStatusService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ActiveTypeStatus")
public class ActiveTypeStatusController {
	
	private final  ActiveTypeStatusService activeTypeStatusService;

	public ActiveTypeStatusController(ActiveTypeStatusService activeTypeStatusService) {
		super();
		this.activeTypeStatusService = activeTypeStatusService;
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ActiveTypeStatusDto>> getAll(){
		List<ActiveTypeStatusDto> listResActiveTypeStatusDtos = activeTypeStatusService.getAllActiveTypeStatus();
		return new ResponseEntity<List<ActiveTypeStatusDto>>(listResActiveTypeStatusDtos,HttpStatus.ACCEPTED);
	}

}
