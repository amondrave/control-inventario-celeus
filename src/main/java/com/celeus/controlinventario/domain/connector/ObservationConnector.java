package com.celeus.controlinventario.domain.connector;

import java.util.List;

import com.celeus.controlinventario.persistence.entity.Maintenance;
import com.celeus.controlinventario.persistence.entity.Observation;

public interface ObservationConnector {
	
	List<Observation> getAllObservationByMaintenance(Maintenance maintenance);
	
	Observation createObservation(Observation observation);
	
	Observation getObservationById(Long id);
	
	void deleteObservation(Long id);

}
