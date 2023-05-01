package com.celeus.controlinventario.domain.connector;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.celeus.controlinventario.persistence.entity.Active;

@Repository
public interface ActiveConnector {

	List<Active> getAllActivesEnabled();
}
