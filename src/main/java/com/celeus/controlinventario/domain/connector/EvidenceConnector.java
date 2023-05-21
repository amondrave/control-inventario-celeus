package com.celeus.controlinventario.domain.connector;

import java.util.List;

import com.celeus.controlinventario.persistence.entity.Evidence;
import com.celeus.controlinventario.persistence.entity.Maintenance;

public interface EvidenceConnector {
	
	List<Evidence> getAllEvidenceByMaintenance(Long maintenance);
	
	Evidence createEvidence(Evidence evidence);
	
	Evidence getEvidenceById(Long id);
	
	void deleteEvidence(Long id);

}
