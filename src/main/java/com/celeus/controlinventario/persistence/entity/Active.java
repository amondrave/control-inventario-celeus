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
@Getter
@Setter
@Builder
@Entity
@Table(name = "active")
public class Active {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_active_type")
	private ActiveType activeType;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "serial", nullable = false)
	private String serial;
	
	@Column(name = "characteristic", nullable = true)
	private String characteristic;
	
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "year_acquired", nullable = false)
	private String yearAcquired;
	
	@Column(name = "value", nullable = false)
	private Double value;
	
	@Column(name = "code", nullable = false, unique = true)
	private String code;
	
	@Column(name = "image", length = 1500)
	private String image;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_user")
	private User user;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@Column(name = "update_date")
	private LocalDateTime updateDate;
	
	@Column(name = "enabled", columnDefinition="tinyint(1) default 1" )
	private Boolean enabled;
	
	
}
