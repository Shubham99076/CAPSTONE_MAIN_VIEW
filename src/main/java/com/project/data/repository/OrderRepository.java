package com.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.data.model.OrderInfo;

public interface OrderRepository extends JpaRepository<OrderInfo, Long> {

}
