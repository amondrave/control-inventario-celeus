package com.celeus.controlinventario.domain.connector.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.celeus.controlinventario.domain.connector.ActiveConnector;
import com.celeus.controlinventario.domain.dto.ActiveDto;
import com.celeus.controlinventario.domain.dto.ActiveTypeDto;
import com.celeus.controlinventario.persistence.entity.Active;
import com.celeus.controlinventario.persistence.mapper.ActiveMapper;
import com.celeus.controlinventario.persistence.repository.ActiveRepository;

@Repository
public class ActiveConnectorImpl implements ActiveConnector{
	
	private final ActiveRepository activeRepository;
	
	private final ActiveMapper activeMapper;

	
	
	public ActiveConnectorImpl(ActiveRepository activeRepository, ActiveMapper activeMapper) {
		super();
		this.activeRepository = activeRepository;
		this.activeMapper = activeMapper;
	}

	@Override
	public List<Active> getAllActivesEnabled() {
		return activeRepository.findEnabledActives() ;
	}

	@Override
	public Active createActive(ActiveDto activeDto) {
		// TODO Auto-generated method stub
		Active active = activeMapper.dtoToEntity(activeDto);
		active.setCreatedDate(LocalDateTime.now());
		active.setUpdateDate(LocalDateTime.now());
		active.setCode(this.createCodeActive(activeDto.getActiveTypeDto()));
		return activeRepository.saveAndFlush(active);
	}
	
	
	private String createCodeActive(ActiveTypeDto activeTypeDto) {
		StringBuilder code = new StringBuilder(activeTypeDto.getSigle());
		Long nextId = activeRepository.getNextId();
		code.append(nextId);
		return code.toString();
	}

	@Override
	public Active updateActive(ActiveDto activeDto) {
		// TODO Auto-generated method stub
		Active active = activeMapper.dtoToEntity(activeDto);
		active.setUpdateDate(LocalDateTime.now());
		return activeRepository.saveAndFlush(active);
	}

	@Override
	public Active getActiveById(Long id) {
		// TODO Auto-generated method stub
		Active activeExistente = activeRepository.findById(id)
	            .orElseThrow(() -> new NoSuchElementException("No se encontró el activo con ID " + id));
		return activeExistente;
	}

	@Override
	public Active getActiveByCode(String code) {
		return activeRepository.findByCode(code)
	            .orElseThrow(() -> new NoSuchElementException("No se encontró el Active con código " + code));
	}

	@Override
	public void enabledActive(Long id) {
			Active active = getActiveById(id);
            active.setEnabled(false);
            activeRepository.save(active);
	}

}
