package com.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.data.model.InvoiceInfo;

public interface InvoiceRepository extends JpaRepository<InvoiceInfo, Long> {

}
