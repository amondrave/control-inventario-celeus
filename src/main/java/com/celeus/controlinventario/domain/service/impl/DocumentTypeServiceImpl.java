package com.celeus.controlinventario.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.DocumentTypeConnector;
import com.celeus.controlinventario.domain.dto.DocumentTypeDto;
import com.celeus.controlinventario.domain.service.DocumentTypeService;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
	
	private final DocumentTypeConnector documentTypeConnector;
	
	

	public DocumentTypeServiceImpl(DocumentTypeConnector documentTypeConnector) {
		super();
		this.documentTypeConnector = documentTypeConnector;
	}



	@Override
	public List<DocumentTypeDto> getAllDcoumentType() {
		// TODO Auto-generated method stub
		return documentTypeConnector.getAllDocumentType();
	}

}
