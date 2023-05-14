package com.celeus.controlinventario.domain.connector.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.EvidenceConnector;
import com.celeus.controlinventario.persistence.entity.Evidence;
import com.celeus.controlinventario.persistence.entity.Maintenance;
import com.celeus.controlinventario.persistence.repository.EvidenceRepository;

@Repository
public class EvidenceConnectorImpl implements EvidenceConnector {
	
	private final EvidenceRepository evidenceRepository;
	
	

	public EvidenceConnectorImpl(EvidenceRepository evidenceRepository) {
		super();
		this.evidenceRepository = evidenceRepository;
	}

	@Override
	public List<Evidence> getAllEvidenceByMaintenance(Maintenance maintenance) {
		// TODO Auto-generated method stub
		return evidenceRepository.findByMaintenance(maintenance);
	}

	@Override
	public Evidence createEvidence(Evidence evidence) {
		// TODO Auto-generated method stub
		evidence.setCreatedDate(LocalDateTime.now());
		return evidenceRepository.saveAndFlush(evidence);
	}

	@Override
	public Evidence getEvidenceById(Long id) {
		// TODO Auto-generated method stub
		Evidence evidence = evidenceRepository.getReferenceById(id);
		if(evidence == null)
			new NoSuchElementException("No se encontró la evidencia con ID " + id);
		return evidence;
	}

	@Override
	public void deleteEvidence(Long id) {
		// TODO Auto-generated method stub
		Evidence evidence = this.getEvidenceById(id);
		evidenceRepository.delete(evidence);
	}

}
