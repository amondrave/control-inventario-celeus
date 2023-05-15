package com.celeus.controlinventario.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.celeus.controlinventario.domain.connector.WorkerConnector;
import com.celeus.controlinventario.domain.dto.WorkerDto;
import com.celeus.controlinventario.domain.service.WorkerService;
import com.celeus.controlinventario.persistence.entity.Worker;
import com.celeus.controlinventario.persistence.mapper.WorkerMapper;


@Service
public class WorkerServiceImpl implements WorkerService {
	
	private final WorkerConnector workerConnector;
	
	private final WorkerMapper workerMapper;
	
	

	public WorkerServiceImpl(WorkerConnector workerConnector, WorkerMapper workerMapper) {
		super();
		this.workerConnector = workerConnector;
		this.workerMapper = workerMapper;
	}

	@Override
	public WorkerDto getWorkerByIdentifcationAndDocument(String identification, Long documentTypeId) {
		// TODO Auto-generated method stub
		return workerMapper.entityToDto(workerConnector.getWorkerByIdentifcationAndDocument(identification, documentTypeId));
	}

	@Override
	public WorkerDto createWorker(WorkerDto workerDto) {
		// TODO Auto-generated method stub
		Worker worker = workerMapper.dtoToEntity(workerDto);
		return workerMapper.entityToDto(workerConnector.createWorker(worker));
	}

	@Override
	public List<WorkerDto> getAllWorker() {
		List<Worker> mapperlist = workerConnector.getAllWorker();
		if(!mapperlist.isEmpty()) {
			return this.mapperList(mapperlist);
		}
		return null;
	}
	
	private List<WorkerDto> mapperList(List<Worker> mapperlist){
		return mapperlist.stream()
				.map(w -> {
					WorkerDto workerDto = workerMapper.entityToDto(w);
					return workerDto;
				})
				.collect(Collectors.toList());
	}

}
