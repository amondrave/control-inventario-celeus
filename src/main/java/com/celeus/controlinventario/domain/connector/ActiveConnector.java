package com.celeus.controlinventario.domain.connector;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.dto.ActiveDto;
import com.celeus.controlinventario.persistence.entity.Active;

@Repository
public interface ActiveConnector {

	List<Active> getAllActivesEnabled();
	
	List<Active> getAllActivesNotAssigments();
	
	Active createActive(ActiveDto activeDto);
	
	Active updateActive(ActiveDto activeDto);
	
	Active getActiveById(Long id);
	
	Active getActiveByCode(String code);
	
	void enabledActive(Long id);
	
}
