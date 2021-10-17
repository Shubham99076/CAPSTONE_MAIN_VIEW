package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.data.model.InvoiceInfo;

@Service
public interface InvoiceService {
	
	void addInvoice(InvoiceInfo invoiceInfo);
	void updatePayment(InvoiceInfo invoiceInfo);
	 Optional<InvoiceInfo> findOrderId(Long poid);
	 List<InvoiceInfo> allInvoice();

}
