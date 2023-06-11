package com.celeus.controlinventario.domain.connector.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.DeparmentConnector;
import com.celeus.controlinventario.domain.dto.DeparmentDto;
import com.celeus.controlinventario.persistence.entity.Deparment;
import com.celeus.controlinventario.persistence.mapper.DeparmentMapper;
import com.celeus.controlinventario.persistence.repository.DeparmentRepository;

@Repository
public class DeparmentConnectorImpl implements DeparmentConnector{
	
	private final DeparmentRepository deparmentRepository;
	
	private final DeparmentMapper deparmentMapper;
	
	

	public DeparmentConnectorImpl(DeparmentRepository deparmentRepository, DeparmentMapper deparmentMapper) {
		super();
		this.deparmentRepository = deparmentRepository;
		this.deparmentMapper = deparmentMapper;
	}



	@Override
	public List<DeparmentDto> getAllDeparment() {
		// TODO Auto-generated method stub
		List<Deparment> listDeparments = deparmentRepository.findAll();
		List<DeparmentDto> response = mapperList(listDeparments);
		return response;
	}
	
	private List<DeparmentDto> mapperList(List<Deparment> listDeparments){
		return listDeparments.stream()
				.map(d -> {
					DeparmentDto deparmentDto = deparmentMapper.entityToDto(d);
					return deparmentDto;
				})
				.collect(Collectors.toList());
	}



	@Override
	public DeparmentDto getDeparmentById(Long id) {
		try {
			return deparmentMapper.entityToDto(deparmentRepository.getById(id));
		} catch (Exception e) {
			throw new NoSuchElementException("No se pudo encontrar");
		}
	}

}
