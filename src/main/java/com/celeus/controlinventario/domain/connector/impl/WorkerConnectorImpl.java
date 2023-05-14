package com.celeus.controlinventario.domain.connector.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.domain.connector.WorkerConnector;
import com.celeus.controlinventario.persistence.entity.Worker;
import com.celeus.controlinventario.persistence.repository.WorkerRepository;

@Repository
public class WorkerConnectorImpl implements WorkerConnector {
	
	private final WorkerRepository workerRepository;
	
	

	public WorkerConnectorImpl(WorkerRepository workerRepository) {
		super();
		this.workerRepository = workerRepository;
	}

	@Override
	public Worker getWorkerByIdentifcationAndDocument(String identification, Long documentTypeId) {
		// TODO Auto-generated method stub
		Worker worker = workerRepository.findWorkerByIdentificationAndDocumentType(identification, documentTypeId);
		if(worker == null) {
			new NoSuchElementException("No se encontró el Trabajador con identificación " + identification);
		}
		return worker;
	}

	@Override
	public Worker createWorker(Worker worker) {
		// TODO Auto-generated method stub
		return workerRepository.saveAndFlush(worker);
	}

	@Override
	public List<Worker> getAllWorker() {
		// TODO Auto-generated method stub
		return workerRepository.findAll();
	}

}
