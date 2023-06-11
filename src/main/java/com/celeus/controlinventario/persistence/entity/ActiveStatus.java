package com.celeus.controlinventario.persistence.entity;




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
