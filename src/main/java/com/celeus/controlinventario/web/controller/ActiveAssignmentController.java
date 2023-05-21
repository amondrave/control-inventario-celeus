package com.celeus.controlinventario.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/find/active/{idActive}")
	public ResponseEntity<List<ActiveAssignmentDto>> getAllByActive(@PathVariable("idActive") Long active){
		List<ActiveAssignmentDto> lisActiveAssignmentDtos = activeAssignmentService.getAllActiveAssignmentByActive(active);
		return new ResponseEntity<List<ActiveAssignmentDto>>(lisActiveAssignmentDtos,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<ActiveAssignmentDto> getById(@PathVariable("id") Long id){
		ActiveAssignmentDto ActiveAssignmentDtoResponse = activeAssignmentService.getActiveAssignmentById(id);
		return new ResponseEntity<ActiveAssignmentDto>(ActiveAssignmentDtoResponse,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity delete(Long id) {
		activeAssignmentService.deleteActiveAssignment(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
}
