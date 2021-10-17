package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.project.data.model.OrderInfo;
import com.project.data.model.PurchaseOrderInfo;

@Service
public interface OrderService {
	void createOrder(OrderInfo orderInfo);
	 Optional<OrderInfo> findOrderId(Long poid);
	 List<OrderInfo> allOrder();
	
}
