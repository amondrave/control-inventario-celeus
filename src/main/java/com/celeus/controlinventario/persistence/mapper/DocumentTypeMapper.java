package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.DocumentTypeDto;
import com.celeus.controlinventario.persistence.entity.DocumentType;

@Component
public class DocumentTypeMapper {

	public DocumentTypeDto entityToDto(DocumentType documentType) {
		return DocumentTypeDto.builder()
				.id(documentType.getId())
				.name(documentType.getName())
				.sigle(documentType.getSigle())
				.build();
	}
	
	public DocumentType dtoToEntity(DocumentTypeDto documentTypeDto) {
		return DocumentType.builder()
				.id(documentTypeDto.getId())
				.name(documentTypeDto.getName())
				.sigle(documentTypeDto.getSigle())
				.build();
	}
	
}
