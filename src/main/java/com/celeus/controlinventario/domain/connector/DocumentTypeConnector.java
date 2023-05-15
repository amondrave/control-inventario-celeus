package com.celeus.controlinventario.domain.connector;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.dto.DocumentTypeDto;
import com.celeus.controlinventario.persistence.entity.DocumentType;

@Repository
public interface DocumentTypeConnector {

	List<DocumentTypeDto> getAllDocumentType();
	
	DocumentType getDocumenTypeById(Long id);
	
}
