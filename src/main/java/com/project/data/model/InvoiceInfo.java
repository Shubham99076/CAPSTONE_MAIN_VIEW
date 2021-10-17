package com.project.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "invoice")
public class InvoiceInfo {

	@Id
	@Column(name = "invoiceid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long invoiceid;

	@Column(name = "amount")
	private Integer amount;

	@Column(name = "quantity")
	private Integer quantity;
	
	@OneToOne
	@JoinColumn(name = "poid")	
	private PurchaseOrderInfo poid;

	@Column(name = "description")
	private String description;
	
	@Column(name = "payment_status")
	private String payment_status;
	
	@Column(name = "paid_amount")
	private Integer paid_amount;
	
	@Column(name = "remaing_amount")
	private Integer remaing_amount;
	
	@CreatedDate
	@Column(name = "createdAt")
	private Date createdAt;
	
	  @LastModifiedDate
	@Column(name = "updatedAt")
	private Date updatedAt;

	public InvoiceInfo() {
		super();
	}

	public Long getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(Long invoiceid) {
		this.invoiceid = invoiceid;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PurchaseOrderInfo getPoid() {
		return poid;
	}

	public void setPoid(PurchaseOrderInfo poid) {
		this.poid = poid;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public Integer getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(Integer paid_amount) {
		this.paid_amount = paid_amount;
	}

	public Integer getRemaing_amount() {
		return remaing_amount;
	}

	public void setRemaing_amount(Integer remaing_amount) {
		this.remaing_amount = remaing_amount;
	}

	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
