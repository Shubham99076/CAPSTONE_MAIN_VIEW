package com.project.data.model;

public class ReportInfo {
	
	private int poid;
	private int orderid;
	private int invoiceid;
	private int amount;
	private int total_amount;
	private int paid_amount;
	private int remaining_amount;
	private int qty;
	private String cust_name;
	private String cust_email;
	private String cust_mob;
	private String created_at;
	private String updated_at;
	private String po_status;
	private String invoice_status;
	private String item_name;
	private String cat_name;
	private int recieving_amount;
	private int remaing_amount;
	
	
	
	
	public int getRecieving_amount() {
		return recieving_amount;
	}
	public void setRecieving_amount(int recieving_amount) {
		this.recieving_amount = recieving_amount;
	}
	public int getRemaing_amount() {
		return remaing_amount;
	}
	public void setRemaing_amount(int remaing_amount) {
		this.remaing_amount = remaing_amount;
	}
	public int getPoid() {
		return poid;
	}
	public void setPoid(int poid) {
		this.poid = poid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public int getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(int paid_amount) {
		this.paid_amount = paid_amount;
	}
	public int getRemaining_amount() {
		return remaining_amount;
	}
	public void setRemaining_amount(int remaining_amount) {
		this.remaining_amount = remaining_amount;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
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
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getPo_status() {
		return po_status;
	}
	public void setPo_status(String po_status) {
		this.po_status = po_status;
	}
	public String getInvoice_status() {
		return invoice_status;
	}
	public void setInvoice_status(String invoice_status) {
		this.invoice_status = invoice_status;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	
	
	
	
	
	

}
