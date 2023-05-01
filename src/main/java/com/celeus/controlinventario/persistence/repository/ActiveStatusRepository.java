package com.celeus.controlinventario.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celeus.controlinventario.persistence.entity.ActiveStatus;

public interface ActiveStatusRepository extends JpaRepository<ActiveStatus, Long> {

}
