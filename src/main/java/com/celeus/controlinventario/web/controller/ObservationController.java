package com.celeus.controlinventario.web.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celeus.controlinventario.domain.dto.ObservationDto;
import com.celeus.controlinventario.domain.service.ObservationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/observation")
public class ObservationController {
	
	private final ObservationService observationService;

	public ObservationController(ObservationService observationService) {
		super();
		this.observationService = observationService;
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<ObservationDto> getById(@PathVariable Long id){
		ObservationDto observationDto = observationService.getIdObservationById(id);
		return new ResponseEntity<ObservationDto>(observationDto,HttpStatus.OK);
	}
	
	@GetMapping("/findAll/active/{idActive}")
	public ResponseEntity<List<ObservationDto>> getAllByActive(@PathVariable Long idActive){
		List<ObservationDto> observationDtos = observationService.getObservationByIdMaintenance(idActive);
		return new ResponseEntity<List<ObservationDto>>(observationDtos,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		observationService.deleteObservation(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	

}
