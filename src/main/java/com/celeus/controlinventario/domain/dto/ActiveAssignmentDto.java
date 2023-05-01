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
public class ActiveAssignmentDto {
	
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate requestDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate returnDate;
	
	private Boolean loan;
	
	private WorkerDto workerDto;
	
	private String location;
	
	private String typeAssignment;
	
	private ActiveDto activeDto;
	
	private String reason;
	
	private String authorization;
	
	private Double totalValue;
	
	private UserDto userDto;
	
	

}
