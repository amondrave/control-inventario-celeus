package com.celeus.controlinventario.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.celeus.controlinventario.domain.connector.WorkerConnector;
import com.celeus.controlinventario.domain.dto.DocumentTypeDto;
import com.celeus.controlinventario.domain.dto.WorkerDto;
import com.celeus.controlinventario.domain.service.ChargeService;
import com.celeus.controlinventario.domain.service.DocumentTypeService;
import com.celeus.controlinventario.domain.service.WorkerService;
import com.celeus.controlinventario.persistence.entity.Worker;
import com.celeus.controlinventario.persistence.mapper.WorkerMapper;


@Service
public class WorkerServiceImpl implements WorkerService {
	
	private final WorkerConnector workerConnector;
	
	private final WorkerMapper workerMapper;
	
	private final ChargeService chargeService;
	
	private final DocumentTypeService documentTypeService;
	
	

	public WorkerServiceImpl(WorkerConnector workerConnector, WorkerMapper workerMapper
			, ChargeService chargeService, DocumentTypeService documentTypeService) {
		super();
		this.workerConnector = workerConnector;
		this.workerMapper = workerMapper;
		this.chargeService = chargeService;
		this.documentTypeService = documentTypeService;
	}

	@Override
	public WorkerDto getWorkerByIdentifcationAndDocument(String identification, Long documentTypeId) {
		// TODO Auto-generated method stub
		return workerMapper.entityToDto(workerConnector.getWorkerByIdentifcationAndDocument(identification, documentTypeId));
	}

	@Override
	@Transactional
	public WorkerDto createWorker(WorkerDto workerDto) {
		// TODO Auto-generated method stub
		workerDto.setChargeDto(chargeService.getChargeById(workerDto.getChargeDto().getId()));
		workerDto.setDocumentTypeDto(documentTypeService.getDocumentTypeById(workerDto.getDocumentTypeDto().getId()));

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

	@Override
	public WorkerDto getWorkedById(Long id) {
		// TODO Auto-generated method stub
		return workerMapper.entityToDto(workerConnector.getWorkerById(id));
	}

}
