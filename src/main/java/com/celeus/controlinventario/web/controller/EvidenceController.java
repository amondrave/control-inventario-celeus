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

import com.celeus.controlinventario.domain.dto.EvidenceDto;
import com.celeus.controlinventario.domain.service.EvidenceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/evidence")
public class EvidenceController {
	
	private final EvidenceService evidenceService;

	public EvidenceController(EvidenceService evidenceService) {
		super();
		this.evidenceService = evidenceService;
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<EvidenceDto> getById(@PathVariable Long id){
		EvidenceDto evidenceDto = evidenceService.getEvidenceById(id);
		return new ResponseEntity<EvidenceDto>(evidenceDto,HttpStatus.OK);
	}
	
	@GetMapping("/findAll/active/{idActive}")
	public ResponseEntity<List<EvidenceDto>> getAllByActive(@PathVariable Long idActive){
		List<EvidenceDto> evidenceDtos = evidenceService.getEvidenceDtoByMaintenance(idActive);
		return new ResponseEntity<List<EvidenceDto>>(evidenceDtos,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		evidenceService.deleteEvidence(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	

}
