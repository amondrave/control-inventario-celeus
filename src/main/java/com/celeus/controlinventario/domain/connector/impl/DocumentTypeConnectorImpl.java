package com.celeus.controlinventario.domain.connector.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.DocumentTypeConnector;
import com.celeus.controlinventario.domain.dto.DocumentTypeDto;
import com.celeus.controlinventario.persistence.entity.DocumentType;
import com.celeus.controlinventario.persistence.mapper.DocumentTypeMapper;
import com.celeus.controlinventario.persistence.repository.DocumentTypeRepository;

@Repository
public class DocumentTypeConnectorImpl implements DocumentTypeConnector {
	
	private final DocumentTypeMapper documentTypeMapper;
	
	private final DocumentTypeRepository documentTypeRepository;
	
	

	public DocumentTypeConnectorImpl(DocumentTypeMapper documentTypeMapper,
			DocumentTypeRepository documentTypeRepository) {
		super();
		this.documentTypeMapper = documentTypeMapper;
		this.documentTypeRepository = documentTypeRepository;
	}



	@Override
	public List<DocumentTypeDto> getAllDocumentType() {
		// TODO Auto-generated method stub
		List<DocumentType> listDocumentTypes = documentTypeRepository.findAll();
		return mapperList(listDocumentTypes);
	}

	
	private List<DocumentTypeDto> mapperList(List<DocumentType> listDocumentTypes){
		return listDocumentTypes.stream()
				.map(d -> {
					DocumentTypeDto documentTypeDto = documentTypeMapper.entityToDto(d);
					return documentTypeDto;
				})
				.collect(Collectors.toList());
				
	}
}
