package com.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.data.model.PurchaseOrderInfo;

public interface POOrderRepository extends JpaRepository<PurchaseOrderInfo, Long> {

}
