package com.celeus.controlinventario.domain.service;

import java.util.List;

import com.celeus.controlinventario.domain.dto.EvidenceDto;

public interface EvidenceService {
	
	EvidenceDto createEvidence(EvidenceDto evidenceDto);
	
	EvidenceDto getEvidenceById(Long id);
	
	List<EvidenceDto> getEvidenceDtoByMaintenance(Long idMaintenance);
	
	void deleteEvidence(Long id);
}
