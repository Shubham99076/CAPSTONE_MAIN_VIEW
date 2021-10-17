package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.data.model.OrderInfo;
import com.project.data.model.PurchaseOrderInfo;
import com.project.data.repository.OrderRepository;

@Component
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public void createOrder(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		
		orderRepository.save(orderInfo);
	}
	
	@Override
	public Optional<OrderInfo> findOrderId(Long poid) {
		// TODO Auto-generated method stub
		return orderRepository.findById(poid);
	}

	@Override
	public List<OrderInfo> allOrder() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

}
