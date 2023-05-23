package com.celeus.controlinventario.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celeus.controlinventario.domain.dto.LeavingFormatDto;
import com.celeus.controlinventario.domain.service.LeavingFormatService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/LeavingFormat")
public class LeavingFormatController {

	
	private final LeavingFormatService leavingFormatService;

	public LeavingFormatController(LeavingFormatService leavingFormatService) {
		super();
		this.leavingFormatService = leavingFormatService;
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<LeavingFormatDto>> getAll(){
		List<LeavingFormatDto> list = leavingFormatService.getAllLeavingFormat();
		return new ResponseEntity<List<LeavingFormatDto>>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/find/active/{idActive}")
	public ResponseEntity<List<LeavingFormatDto>> getAllByActive(@PathVariable("idActive") Long idActive){
		List<LeavingFormatDto> list = leavingFormatService.getAllLeavingFormatByActiveId(idActive);
		return new ResponseEntity<List<LeavingFormatDto>>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<LeavingFormatDto> getById(@PathVariable Long id){
		LeavingFormatDto leavingFormatDto = leavingFormatService.getLeavingFormatDtoById(id);
		return new ResponseEntity<LeavingFormatDto>(leavingFormatDto,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<LeavingFormatDto> create(@RequestBody LeavingFormatDto leavingFormatDto){
		LeavingFormatDto leavingFormatDto2 = leavingFormatService.createLeavingFormat(leavingFormatDto);
		return new ResponseEntity<LeavingFormatDto>(leavingFormatDto2,HttpStatus.CREATED);
	}
	
}
