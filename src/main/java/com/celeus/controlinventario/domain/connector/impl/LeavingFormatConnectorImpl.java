package com.celeus.controlinventario.domain.connector.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.LeavingFormatConnector;
import com.celeus.controlinventario.persistence.entity.LeavingFormat;
import com.celeus.controlinventario.persistence.repository.LeavingFormatRepository;

@Repository
public class LeavingFormatConnectorImpl implements LeavingFormatConnector {
	
	private final LeavingFormatRepository leavingFormatRepository;
	
	

	public LeavingFormatConnectorImpl(LeavingFormatRepository leavingFormatRepository) {
		super();
		this.leavingFormatRepository = leavingFormatRepository;
	}

	@Override
	public List<LeavingFormat> getAllLeavingFormat() {
		// TODO Auto-generated method stub
		return leavingFormatRepository.findAll();
	}

	@Override
	public List<LeavingFormat> getAllLeavingFormatByActiveId(Long idActive) {
		// TODO Auto-generated method stub
		return leavingFormatRepository.findByActiveId(idActive);
	}

	@Override
	public LeavingFormat createLeavingFormat(LeavingFormat leavingFormat) {
		// TODO Auto-generated method stub
		leavingFormat.setUpdateDate(LocalDateTime.now());
		return leavingFormatRepository.saveAndFlush(leavingFormat);
	}

	@Override
	public LeavingFormat getLeavingFormatById(Long id) {
		// TODO Auto-generated method stub
		try {
			return leavingFormatRepository.getReferenceById(id);
		} catch (Exception e) {
			throw new NoSuchElementException("No se puede recuperar ese proceso de baja");
		}
	}

}
