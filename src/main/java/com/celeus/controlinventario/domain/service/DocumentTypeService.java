package com.celeus.controlinventario.domain.service;

import java.util.List;

import com.celeus.controlinventario.domain.dto.DocumentTypeDto;

public interface DocumentTypeService {
	
	List<DocumentTypeDto> getAllDcoumentType();
	
	DocumentTypeDto getDocumentTypeById(Long id);

}
