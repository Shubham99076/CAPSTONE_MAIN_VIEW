package com.project.data.model;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "order_tbl")
public class OrderInfo {

	@Id
	@Column(name = "orderid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderid;
	@Column(name = "cust_name")
	private String cust_name;
	@Column(name = "cust_email")
	private String cust_email;
	@Column(name = "cust_mob")
	private String cust_mob;
	@Column(name = "category_name")
	private String category_name;
	@Column(name = "qty")
	private int qty;
	@Column(name = "item_name")
	private String item_name; 
	@Column(name = "price")
	private int price;
	
	@CreatedDate
	@Column(name = "createdAt")
	private Date createdAt;
	
	  @LastModifiedDate
	@Column(name = "updatedAt")
	private Date updatedAt;
	
	
	
	
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_email() {
		return cust_email;
	}
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	public String getCust_mob() {
		return cust_mob;
	}
	public void setCust_mob(String cust_mob) {
		this.cust_mob = cust_mob;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
