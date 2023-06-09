package com.celeus.controlinventario.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celeus.controlinventario.domain.dto.ActiveStatusDto;
import com.celeus.controlinventario.domain.service.ActiveStatusService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ActiveStatus")
public class ActiveStatusController {

	private final ActiveStatusService activeStatusService;

	public ActiveStatusController(ActiveStatusService activeStatusService) {
		super();
		this.activeStatusService = activeStatusService;
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ActiveStatusDto>> getAll(){
		List<ActiveStatusDto> list = activeStatusService.getAllActiveStatus();
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findAll/active/{idActive}")
	public ResponseEntity<List<ActiveStatusDto>> getAllByActive(@PathVariable("idActive") Long idActive){
		List<ActiveStatusDto> list = activeStatusService.getAllActiveStatusByActive(idActive);
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findAll/typeStatus")
	public ResponseEntity<List<ActiveStatusDto>> getAllByActive(){
		List<ActiveStatusDto> list = activeStatusService.getByActiveTypeStatus();
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<ActiveStatusDto> getActiveStatusById(@PathVariable Long id){
		ActiveStatusDto activeStatusDto = activeStatusService.getActiveStatusById(id);
		return new ResponseEntity<ActiveStatusDto>(activeStatusDto,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ActiveStatusDto> create(@RequestBody ActiveStatusDto activeStatusDto){
		ActiveStatusDto activeStatusDto2 = activeStatusService.createActiveStatus(activeStatusDto);
		return new ResponseEntity<ActiveStatusDto>(activeStatusDto2,HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		activeStatusService.deleteACtiveStatus(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	
}
