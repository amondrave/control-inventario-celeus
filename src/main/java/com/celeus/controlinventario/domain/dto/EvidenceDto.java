package com.celeus.controlinventario.domain.dto;

import java.time.LocalDateTime;

import com.celeus.controlinventario.persistence.entity.ActiveType;
import com.celeus.controlinventario.persistence.entity.User;

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
public class EvidenceDto {
	
	private Long id;
	
	private String evidenceUrl;
	
	private MaintenanceDto maintenanceDto;
	
	private UserDto userDto;
	
	private String imageBase;

}
