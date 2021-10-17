package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.data.model.InvoiceInfo;
import com.project.data.model.PurchaseOrderInfo;
import com.project.data.repository.POOrderRepository;

@Component
public class POServiceImpl implements POService {

	@Autowired
	POOrderRepository poOrderRepository;
	
	@Override
	public void createPO(PurchaseOrderInfo poorderInfo) {
		
		poOrderRepository.save(poorderInfo);
		
	}

	@Override
	public void updatePO(PurchaseOrderInfo poorderInfo) {
		// TODO Auto-generated method stub
		poOrderRepository.save(poorderInfo);
		
	}
	
	@Override
	public Optional<PurchaseOrderInfo> findOrderId(Long poid) {
		// TODO Auto-generated method stub
		return poOrderRepository.findById(poid);
	}

	@Override
	public List<PurchaseOrderInfo> allPoOrder() {
		// TODO Auto-generated method stub
		return poOrderRepository.findAll();
	}
}
