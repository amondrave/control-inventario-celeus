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
