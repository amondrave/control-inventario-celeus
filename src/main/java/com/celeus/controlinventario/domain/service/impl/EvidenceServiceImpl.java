package com.celeus.controlinventario.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.celeus.controlinventario.domain.connector.EvidenceConnector;
import com.celeus.controlinventario.domain.dto.EvidenceDto;
import com.celeus.controlinventario.domain.service.EvidenceService;
import com.celeus.controlinventario.persistence.entity.Evidence;
import com.celeus.controlinventario.persistence.mapper.EvidenceMapper;

public class EvidenceServiceImpl implements EvidenceService {
	
	private final EvidenceConnector evidenceConnector;
	
	private final EvidenceMapper evidenceMapper;
	
	

	public EvidenceServiceImpl(EvidenceConnector evidenceConnector, EvidenceMapper evidenceMapper) {
		super();
		this.evidenceConnector = evidenceConnector;
		this.evidenceMapper = evidenceMapper;
	}

	@Override
	public EvidenceDto createEvidence(EvidenceDto evidenceDto) {
		// TODO Auto-generated method stub
		Evidence evidence = evidenceMapper.dtoToEntity(evidenceDto);
		return evidenceMapper.entityToDto(evidenceConnector.createEvidence(evidence));
	}

	@Override
	public EvidenceDto getEvidenceById(Long id) {
		// TODO Auto-generated method stub
		return evidenceMapper.entityToDto(evidenceConnector.getEvidenceById(id));
	}

	@Override
	public List<EvidenceDto> getEvidenceDtoByMaintenance(Long idMaintenance) {
		// TODO Auto-generated method stub
		List<Evidence> list = evidenceConnector.getAllEvidenceByMaintenance(idMaintenance);
		if(!list.isEmpty()) {
			return mapperList(list);
		}
		return null;
	}
	private List<EvidenceDto> mapperList(List<Evidence> list){
		return list.stream().map(e -> {
			EvidenceDto evidenceDto = evidenceMapper.entityToDto(e);
			return evidenceDto;
		})
				.collect(Collectors.toList());
	}

	@Override
	public void deleteEvidence(Long id) {
		// TODO Auto-generated method stub
		evidenceConnector.deleteEvidence(id);
	}

}
