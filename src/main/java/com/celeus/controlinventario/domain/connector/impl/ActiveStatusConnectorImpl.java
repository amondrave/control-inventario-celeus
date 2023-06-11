package com.celeus.controlinventario.domain.connector.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.ActiveStatusConnector;
import com.celeus.controlinventario.persistence.entity.ActiveStatus;
import com.celeus.controlinventario.persistence.repository.ActiveStatusRepository;

@Repository
public class ActiveStatusConnectorImpl implements ActiveStatusConnector {
	
	private final ActiveStatusRepository activeStatusRepository;
	

	public ActiveStatusConnectorImpl(ActiveStatusRepository activeStatusRepository) {
		super();
		this.activeStatusRepository = activeStatusRepository;
	}

	@Override
	public List<ActiveStatus> getAllActiveStatus() {
		// TODO Auto-generated method stub
		return activeStatusRepository.findAll();
	}

	@Override
	public List<ActiveStatus> getAllActiveStatusByActive(Long activeId) {
		// TODO Auto-generated method stub
		return activeStatusRepository.findByActiveId(activeId);
	}

	@Override
	public ActiveStatus createActiveStatus(ActiveStatus activeStatus) {
		// TODO Auto-generated method stub
		return activeStatusRepository.saveAndFlush(activeStatus);
	}

	@Override
	public void deleteActiveStatus(Long id) {
		// TODO Auto-generated method stub
		try {
			activeStatusRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			throw new NoSuchElementException("No se puede eliminar este estaus del activo");
		}
		
	}

	@Override
	public ActiveStatus getActiveStatusById(Long id) {
		// TODO Auto-generated method stub
		try {
			ActiveStatus activeStatus = activeStatusRepository.getById(id);
			return activeStatus;
		} catch (Exception e) {
			throw new NoSuchElementException("No se encontró el estaus del activo con ID " + id);
		}
	}

	@Override
	public List<ActiveStatus> getByActiveTypeStatus() {
		// TODO Auto-generated method stub
		return activeStatusRepository.findActiveStatusByBadCondition();
	}

}
