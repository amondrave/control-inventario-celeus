package com.celeus.controlinventario.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "active_assignment")
public class ActiveAssignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "request_datet")
	private LocalDate requestDate;
	
	@Column(name = "return_date")
	private LocalDate returnDate;
	
	@Column(name = "loan", columnDefinition="tinyint(1) default 1" )
	private Boolean loan;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_worker")
	private Worker worker;
	
	@Column(name = "location")
	private String location;

	@Column(name = "type_assignment")
	private String typeAssignment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_active")
	private Active active;
	
	@Column(name = "reason", length = 2000)
	private String reason;
	
	@Column(name = "authorization", length = 2000)
	private String authorization;
	
	@Column(name = "total_value", length = 2000)
	private Double totalValue;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_user")
	private User user;
	
	@Column(name = "update_date")
	private LocalDateTime updateDate;
}
