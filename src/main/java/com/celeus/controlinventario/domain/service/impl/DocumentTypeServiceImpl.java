package com.celeus.controlinventario.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.DocumentTypeConnector;
import com.celeus.controlinventario.domain.dto.DocumentTypeDto;
import com.celeus.controlinventario.domain.service.DocumentTypeService;
import com.celeus.controlinventario.persistence.mapper.DocumentTypeMapper;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
	
	private final DocumentTypeConnector documentTypeConnector;
	
	private final DocumentTypeMapper documentTypeMapper;
	

	public DocumentTypeServiceImpl(DocumentTypeConnector documentTypeConnector,
			DocumentTypeMapper documentTypeMapper) {
		super();
		this.documentTypeConnector = documentTypeConnector;
		this.documentTypeMapper = documentTypeMapper;
	}



	@Override
	public List<DocumentTypeDto> getAllDcoumentType() {
		// TODO Auto-generated method stub
		return documentTypeConnector.getAllDocumentType();
	}



	@Override
	public DocumentTypeDto getDocumentTypeById(Long id) {
		// TODO Auto-generated method stub
		return documentTypeMapper.entityToDto(documentTypeConnector.getDocumenTypeById(id));
	}

}
