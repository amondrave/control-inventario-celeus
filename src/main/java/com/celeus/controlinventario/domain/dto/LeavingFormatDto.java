package com.celeus.controlinventario.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.celeus.controlinventario.persistence.entity.ActiveType;
import com.celeus.controlinventario.persistence.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
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
