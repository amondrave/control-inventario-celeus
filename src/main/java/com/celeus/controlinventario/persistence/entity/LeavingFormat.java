package com.celeus.controlinventario.persistence.entity;

import java.time.LocalDate;
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
@Table(name = "leaving_format")
public class LeavingFormat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_active_status")
	private ActiveStatus activeTStatus;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "fk_deparment")
	private Deparment deparment;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_worker")
	private Worker worker;
	
	@Column(name = "date_request")
	private LocalDate dateRequest;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "reason")
	private String reason;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_user")
	private User user;

	@Column(name = "update_date")
	private LocalDateTime updateDate;
}
