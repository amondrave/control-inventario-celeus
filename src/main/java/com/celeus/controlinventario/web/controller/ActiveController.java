package com.celeus.controlinventario.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.celeus.controlinventario.domain.dto.ActiveDto;
import com.celeus.controlinventario.domain.service.ActiveService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("active")
public class ActiveController {
	
		private final ActiveService activeService;
		
		public ActiveController(ActiveService activeService) {
			this.activeService = activeService;
		}
		
		@PostMapping("/create")
		public ResponseEntity<ActiveDto> createActive(@RequestPart("body") String activeDtoString,  @RequestPart("image") MultipartFile file) throws IOException{
			ObjectMapper objectMapper = new ObjectMapper();
		    ActiveDto activeDto = objectMapper.readValue(activeDtoString, ActiveDto.class);
			ActiveDto activeDtoResponse = activeService.saveActive(activeDto, file);
			return new ResponseEntity<ActiveDto>(activeDtoResponse,HttpStatus.CREATED);
		}
		
		@PostMapping("/update")
		public ResponseEntity<ActiveDto> updateActive(@RequestPart("body") String activeDtoString,  @RequestPart("image") MultipartFile file) throws IOException{
			ObjectMapper objectMapper = new ObjectMapper();
		    ActiveDto activeDto = objectMapper.readValue(activeDtoString, ActiveDto.class);
			ActiveDto activeDtoResponse = activeService.updateActive(activeDto, file);
			return new ResponseEntity<ActiveDto>(activeDtoResponse,HttpStatus.OK);
		}
		
		@GetMapping("/findAll")
		public ResponseEntity<List<ActiveDto>> getAllActivesEnabled(){
			List<ActiveDto> activeDtoList = activeService.getAllActivesEnabled();
			return new ResponseEntity<List<ActiveDto>>(activeDtoList,HttpStatus.ACCEPTED);
		}
		
		@GetMapping("/findAll/WithoutAssignment")
		public ResponseEntity<List<ActiveDto>> getAllActivesWithoutAssignment(){
			List<ActiveDto> activeDtoList = activeService.getAllActivesNotAssigments();
			return new ResponseEntity<List<ActiveDto>>(activeDtoList,HttpStatus.ACCEPTED);
		}
		
		@GetMapping("/find/{id}")
		public ResponseEntity<ActiveDto> getActiveById(@PathVariable("id") Long id){
			ActiveDto activeDtoResponse = activeService.getActiveById(id);
			return new ResponseEntity<ActiveDto>(activeDtoResponse,HttpStatus.OK);
		}
		
		@GetMapping("/find/code/{code}")
		public ResponseEntity<ActiveDto> getActiveByCode(@PathVariable("code") String code){
			ActiveDto activeDtoResponse = activeService.getActiveByCode(code);
			return new ResponseEntity<ActiveDto>(activeDtoResponse,HttpStatus.OK);
		}
		
		@GetMapping("/enabled/{id}")
		public ResponseEntity enabledActive(@PathVariable("id") Long id) {
			activeService.enabledActive(id);
			return new ResponseEntity(HttpStatus.OK);
		}
		
		
	
}
