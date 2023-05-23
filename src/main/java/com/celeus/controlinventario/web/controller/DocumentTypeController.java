package com.celeus.controlinventario.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celeus.controlinventario.domain.dto.DocumentTypeDto;
import com.celeus.controlinventario.domain.service.DocumentTypeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/DocumentType")
public class DocumentTypeController {

	
	private final DocumentTypeService documentTypeService;

	public DocumentTypeController(DocumentTypeService documentTypeService) {
		super();
		this.documentTypeService = documentTypeService;
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<DocumentTypeDto>> getAll(){
		List<DocumentTypeDto> listDocumentTypeDtos = documentTypeService.getAllDcoumentType();
		return new ResponseEntity<List<DocumentTypeDto>>(listDocumentTypeDtos,HttpStatus.ACCEPTED);
	}
	
}
