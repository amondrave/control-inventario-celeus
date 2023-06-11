package com.celeus.controlinventario.persistence.entity;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "observation")
public class Observation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "observation", nullable = false, columnDefinition = "TEXT")
	private String observationText;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_maintenance")
	private Maintenance maintenance;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_user")
	private User user;

}
