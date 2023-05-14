package com.celeus.controlinventario.domain.connector.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.ActiveAssignmentConnector;
import com.celeus.controlinventario.persistence.entity.ActiveAssignment;
import com.celeus.controlinventario.persistence.repository.ActiveAssignmentRepository;

@Repository
public class ActiveAssignmentConnectorImpl implements ActiveAssignmentConnector {
	
	private final ActiveAssignmentRepository activeAssignmentRepository;
	
	

	public ActiveAssignmentConnectorImpl(ActiveAssignmentRepository activeAssignmentRepository) {
		super();
		this.activeAssignmentRepository = activeAssignmentRepository;
	}

	@Override
	public List<ActiveAssignment> getAllActiveAssignment() {
		// TODO Auto-generated method stub
		return activeAssignmentRepository.findAll();
	}

	@Override
	public List<ActiveAssignment> getAllActiveAssignmentByActive(Long activeId) {
		// TODO Auto-generated method stub
		return activeAssignmentRepository.findActiveAssignmentByActiveId(activeId);
	}

	@Override
	public ActiveAssignment createActiveAssignment(ActiveAssignment activeAssignment) {
		// TODO Auto-generated method stub
		activeAssignment.setUpdateDate(LocalDateTime.now());
		return activeAssignmentRepository.saveAndFlush(activeAssignment);
	}

	@Override
	public ActiveAssignment getActiveAssignmentById(Long id) {
		// TODO Auto-generated method stub
		try {
			ActiveAssignment activeAssignment = activeAssignmentRepository.getReferenceById(id);
			return activeAssignment;
		} catch (Exception e) {
			throw new NoSuchElementException("No se pudo encontrar el prestamo");
		}
	}

	@Override
	public void deleteActiveAssignment(Long id) {
		try {
			activeAssignmentRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NoSuchElementException("No se pudo eliminar el prestamo");
		}
		
	}
	

}
