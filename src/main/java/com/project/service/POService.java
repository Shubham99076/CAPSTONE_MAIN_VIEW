package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.data.model.InvoiceInfo;
import com.project.data.model.OrderInfo;
import com.project.data.model.PurchaseOrderInfo;

@Service
public interface POService {
	
	void createPO(PurchaseOrderInfo poorderInfo);
	void updatePO(PurchaseOrderInfo poorderInfo);
	 Optional<PurchaseOrderInfo> findOrderId(Long poid);
	 List<PurchaseOrderInfo> allPoOrder();

}
