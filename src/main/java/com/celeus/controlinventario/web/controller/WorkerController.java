package com.celeus.controlinventario.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celeus.controlinventario.domain.dto.WorkerDto;
import com.celeus.controlinventario.domain.service.WorkerService;


@RestController
@RequestMapping("/worker")
@CrossOrigin(origins = "*")
public class WorkerController {
	
	private final WorkerService workerService;

	public WorkerController(WorkerService workerService) {
		super();
		this.workerService = workerService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<WorkerDto> createWorker(@RequestBody WorkerDto workerDto){
		return new ResponseEntity<WorkerDto>(workerService.createWorker(workerDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/find/{identification}/{idDocumentType}")
	public ResponseEntity<WorkerDto> getWorkerByIdentification(@PathVariable String identification, @PathVariable Long idDocumentType){
		WorkerDto WorkerDto = workerService.getWorkerByIdentifcationAndDocument(identification, idDocumentType);
		return new ResponseEntity<WorkerDto>(WorkerDto,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<WorkerDto> getWorkerByIdentification(@PathVariable Long id){
		WorkerDto WorkerDto = workerService.getWorkedById(id);
		return new ResponseEntity<WorkerDto>(WorkerDto,HttpStatus.OK);
	}

}
