package com.celeus.controlinventario.domain.connector.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.ActiveTypeConnector;
import com.celeus.controlinventario.persistence.entity.ActiveType;
import com.celeus.controlinventario.persistence.repository.ActiveTypeRepository;

@Repository
public class ActiveTypeConnectorImpl implements ActiveTypeConnector{
	
	private final ActiveTypeRepository activeTypeRepository;
	
	

	public ActiveTypeConnectorImpl(ActiveTypeRepository activeTypeRepository) {
		super();
		this.activeTypeRepository = activeTypeRepository;
	}

	@Override
	public List<ActiveType> getAllActiveType() {
		// TODO Auto-generated method stub
		return activeTypeRepository.findAll();
	}

	@Override
	public ActiveType findActiveTypeById(Long id) {
		// TODO Auto-generated method stub
		try {
			ActiveType activeType = activeTypeRepository.getReferenceById(id);
			return activeType;
		} catch (Exception e) {
			throw new NoSuchElementException("No se encontró el tipo de activo con ID " + id);
		}	
		
	}

}
