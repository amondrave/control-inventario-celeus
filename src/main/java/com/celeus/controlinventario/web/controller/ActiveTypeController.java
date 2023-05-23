package com.celeus.controlinventario.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celeus.controlinventario.domain.dto.ActiveTypeDto;
import com.celeus.controlinventario.domain.service.ActiveTypeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ActiveType")
public class ActiveTypeController {
	
	private final ActiveTypeService activeTypeService;

	public ActiveTypeController(ActiveTypeService activeTypeService) {
		super();
		this.activeTypeService = activeTypeService;
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ActiveTypeDto>> getAll(){
		List<ActiveTypeDto> listResponse = activeTypeService.getAllActiveType();
		return new ResponseEntity<List<ActiveTypeDto>>(listResponse,HttpStatus.ACCEPTED);
	}
	

}
