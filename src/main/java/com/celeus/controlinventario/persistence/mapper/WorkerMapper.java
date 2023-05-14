package com.celeus.controlinventario.persistence.mapper;

import org.springframework.stereotype.Component;

import com.celeus.controlinventario.domain.dto.WorkerDto;
import com.celeus.controlinventario.persistence.entity.Worker;

@Component
public class WorkerMapper {

    private final DocumentTypeMapper documentTypeMapper;
    private final ChargeMapper chargeMapper;

    public WorkerMapper(DocumentTypeMapper documentTypeMapper, ChargeMapper chargeMapper) {
        this.documentTypeMapper = documentTypeMapper;
        this.chargeMapper = chargeMapper;
    }

    public WorkerDto entityToDto(Worker worker) {
        return WorkerDto.builder()
                .id(worker.getId())
                .name(worker.getName())
                .identification(worker.getIdentification())
                .documentTypeDto(documentTypeMapper.entityToDto(worker.getDocumentType()))
                .chargeDto(chargeMapper.entityToDto(worker.getCharge()))
                .build();
    }

    public Worker dtoToEntity(WorkerDto workerDto) {
        return Worker.builder()
                .id(workerDto.getId())
                .name(workerDto.getName())
                .identification(workerDto.getIdentification())
                .documentType(documentTypeMapper.dtoToEntity(workerDto.getDocumentTypeDto()))
                .charge(chargeMapper.dtoToEntity(workerDto.getChargeDto()))
                .build();
    }
}

