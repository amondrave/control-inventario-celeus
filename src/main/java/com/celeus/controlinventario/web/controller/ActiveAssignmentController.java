package com.celeus.controlinventario.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celeus.controlinventario.domain.dto.ActiveAssignmentDto;
import com.celeus.controlinventario.domain.service.ActiveAssignmentService;

@RestController
@RequestMapping("/ActiveAssignment")
public class ActiveAssignmentController {

	private final ActiveAssignmentService activeAssignmentService;

	public ActiveAssignmentController(ActiveAssignmentService activeAssignmentService) {
		super();
		this.activeAssignmentService = activeAssignmentService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<ActiveAssignmentDto> create(@RequestBody ActiveAssignmentDto activeAssignmentDto) {
		ActiveAssignmentDto ActiveAssignmentDtoResponse = activeAssignmentService.createActiveAssignment(activeAssignmentDto);
		return new ResponseEntity<ActiveAssignmentDto>(ActiveAssignmentDtoResponse,HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ActiveAssignmentDto>> getAll(){
		List<ActiveAssignmentDto> lisActiveAssignmentDtos = activeAssignmentService.getAllActiveAssignment();
		return new ResponseEntity<List<ActiveAssignmentDto>>(lisActiveAssignmentDtos,HttpStatus.ACCEPTED);
	}
}
