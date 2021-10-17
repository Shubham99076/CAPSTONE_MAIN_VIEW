package com.project.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class ItemInfo {

	@Id
	@Column(name = "itemid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemid;

	@Column(name = "item_name", nullable = false)
	private String itemName;

	@Column(nullable = false)
	private Long price;
	
	@Column(nullable = false)
	private Long qty;
	
	@Column(nullable = false)
	private String category_name;
	

	public ItemInfo() {
		super();
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	

	

}
