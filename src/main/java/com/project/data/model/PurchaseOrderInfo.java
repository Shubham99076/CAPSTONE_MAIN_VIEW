package com.project.data.model;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "po_order_tbl")
public class PurchaseOrderInfo {
	
	@Id
	@Column(name = "poid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long poid;
	
	@OneToOne
	@JoinColumn(name = "orderid")	
	private OrderInfo orderid;
	
	@Column(name = "po_status")
	private String po_status;
	
	@CreatedDate
	@Column(name = "createdAt")
	private Date createdAt;
	
	  @LastModifiedDate
	@Column(name = "updatedAt")
	private Date updatedAt;

	public Long getPoid() {
		return poid;
	}

	public void setPoid(Long poid) {
		this.poid = poid;
	}

	public OrderInfo getOrderid() {
		return orderid;
	}

	public void setOrderid(OrderInfo orderid) {
		this.orderid = orderid;
	}

	public String getPo_status() {
		return po_status;
	}

	public void setPo_status(String po_status) {
		this.po_status = po_status;
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
