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
@Table(name = "worker", 
	uniqueConstraints = @UniqueConstraint(name = "UniqueIdentificationAndDocument", 
	columnNames = {"identification","fk_document_type"}))
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", length = 300, nullable = false)
	private String name;
	
	@Column(name = "identification", nullable = false)
	private String identification;
	
	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_document_type")
	private DocumentType documentType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_charge")
	private Charge charge;
	
}
