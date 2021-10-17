package com.project.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.data.model.InvoiceInfo;
import com.project.data.repository.InvoiceRepository;

@Component
public class InvoiceServiceImpl  implements InvoiceService {

	@Autowired
	InvoiceRepository  invoiceRepository;
	
	@Override
	public void addInvoice(InvoiceInfo invoiceInfo) {
		// TODO Auto-generated method stub
		invoiceRepository.save(invoiceInfo);
	}
	
	@Override
	public void updatePayment(InvoiceInfo invoiceInfo) {
		// TODO Auto-generated method stub
		invoiceRepository.save(invoiceInfo);
	}
	
	@Override
	public Optional<InvoiceInfo> findOrderId(Long poid) {
		// TODO Auto-generated method stub
		return invoiceRepository.findById(poid);
	}

	@Override
	public List<InvoiceInfo> allInvoice() {
		// TODO Auto-generated method stub
		return invoiceRepository.findAll();
	}
	
	

}
