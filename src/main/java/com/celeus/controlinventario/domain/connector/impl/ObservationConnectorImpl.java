package com.celeus.controlinventario.domain.connector.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.ObservationConnector;
import com.celeus.controlinventario.persistence.entity.Maintenance;
import com.celeus.controlinventario.persistence.entity.Observation;
import com.celeus.controlinventario.persistence.repository.ObservationRepository;



@Repository
public class ObservationConnectorImpl implements ObservationConnector {
	
	private final ObservationRepository observationRepository;
	

	public ObservationConnectorImpl(ObservationRepository observationRepository) {
		super();
		this.observationRepository = observationRepository;
	}

	@Override
	public List<Observation> getAllObservationByMaintenance(Long maintenanceId) {
		// TODO Auto-generated method stub
		return observationRepository.findByMaintenance(maintenanceId);
	}

	@Override
	public Observation createObservation(Observation observation) {
		observation.setCreatedDate(LocalDateTime.now());
		return observationRepository.saveAndFlush(observation);
	}

	@Override
	public void deleteObservation(Long id) {
		Observation observation = this.getObservationById(id);
		observationRepository.delete(observation);
	}

	@Override
	public Observation getObservationById(Long id) {
		// TODO Auto-generated method stub
		try {
			Observation observation = observationRepository.getReferenceById(id);
			return observation;
		} catch (Exception e) {
			throw new NoSuchElementException("No se encontró la observacion con ID " + id);
		}
		
	}
	

}
