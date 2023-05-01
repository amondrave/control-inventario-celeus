package com.celeus.controlinventario.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.celeus.controlinventario.persistence.entity.DocumentType;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {

}
