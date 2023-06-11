package com.celeus.controlinventario.domain.connector.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.ActiveTypeStatusConnector;
import com.celeus.controlinventario.persistence.entity.ActiveTypeStatus;
import com.celeus.controlinventario.persistence.repository.ActiveTypeStatusRepository;

@Repository
public class ActiveTypeStatusConnectorImpl implements ActiveTypeStatusConnector {
	
	private final ActiveTypeStatusRepository activeTypeStatusRepository;
	
	

	public ActiveTypeStatusConnectorImpl(ActiveTypeStatusRepository activeTypeStatusRepository) {
		super();
		this.activeTypeStatusRepository = activeTypeStatusRepository;
	}



	@Override
	public List<ActiveTypeStatus> getAllActiveTypeStatus() {
		// TODO Auto-generated method stub
		return activeTypeStatusRepository.findAll();
	}



	@Override
	public ActiveTypeStatus getActiveTypeStatusById(Long id) {
		try {
			return activeTypeStatusRepository.getById(id);
		} catch (Exception e) {
			throw new NoSuchElementException("No se puede encontrar");
		}
	}

}
