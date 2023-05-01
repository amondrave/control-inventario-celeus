package com.celeus.controlinventario.domain.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeavingFormatDto {

	private Long id;
	
	private ActiveStatusDto activeStatusDto;
	
	private DeparmentDto deparmentDto;
	
	private UserDto userDto;
	
	private WorkerDto workerDto;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate requestDate;
	
	
	private String status;
	
	private String reason;
	
	// atribustos para la proyeccion
	
	private String nameActive;
	
	private String sigleActive;
	
	private String codeActive;
	
	
}
