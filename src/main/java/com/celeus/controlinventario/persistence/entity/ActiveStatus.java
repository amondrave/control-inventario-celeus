package com.celeus.controlinventario.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "active_status")
public class ActiveStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_active")
	private Active active;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_active_type_status")
	private ActiveTypeStatus activeTypeStatus;
	
	@Column(name = "observation", nullable = false, columnDefinition = "TEXT")
	private String observation;
}
