package com.celeus.controlinventario.persistence.mapper;

import com.celeus.controlinventario.domain.dto.ActiveAssignmentDto;
import com.celeus.controlinventario.persistence.entity.ActiveAssignment;
import org.springframework.stereotype.Component;

@Component
public class ActiveAssignmentMapper {

    private final WorkerMapper workerMapper;
    private final ActiveMapper activeMapper;
    private final UserMapper userMapper;

    public ActiveAssignmentMapper(WorkerMapper workerMapper, ActiveMapper activeMapper, UserMapper userMapper) {
        this.workerMapper = workerMapper;
        this.activeMapper = activeMapper;
        this.userMapper = userMapper;
    }

    public ActiveAssignmentDto entityToDto(ActiveAssignment activeAssignment) {
        return ActiveAssignmentDto.builder()
                .id(activeAssignment.getId())
                .requestDate(activeAssignment.getRequestDate())
                .returnDate(activeAssignment.getReturnDate())
                .loan(activeAssignment.getLoan())
                .workerDto(workerMapper.entityToDto(activeAssignment.getWorker()))
                .location(activeAssignment.getLocation())
                .typeAssignment(activeAssignment.getTypeAssignment())
                .activeDto(activeMapper.entityToDto(activeAssignment.getActive()))
                .reason(activeAssignment.getReason())
                .authorization(activeAssignment.getAuthorization())
                .totalValue(activeAssignment.getTotalValue())
                .userDto(userMapper.entityToDto(activeAssignment.getUser()))
                .build();
    }

    public ActiveAssignment dtoToEntity(ActiveAssignmentDto activeAssignmentDto) {
        return ActiveAssignment.builder()
                .id(activeAssignmentDto.getId())
                .requestDate(activeAssignmentDto.getRequestDate())
                .returnDate(activeAssignmentDto.getReturnDate())
                .loan(activeAssignmentDto.getLoan())
                .worker(workerMapper.dtoToEntity(activeAssignmentDto.getWorkerDto()))
                .location(activeAssignmentDto.getLocation())
                .typeAssignment(activeAssignmentDto.getTypeAssignment())
                .active(activeMapper.dtoToEntity(activeAssignmentDto.getActiveDto()))
                .reason(activeAssignmentDto.getReason())
                .authorization(activeAssignmentDto.getAuthorization())
                .totalValue(activeAssignmentDto.getTotalValue())
                .user(userMapper.dtoToEntity(activeAssignmentDto.getUserDto()))
                .build();
    }

}
