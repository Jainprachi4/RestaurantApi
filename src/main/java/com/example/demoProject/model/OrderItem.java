package com.example.demoProject.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_ITEM_TABLE")
public class OrderItem {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int orderItemId;
	@ManyToOne(cascade = CascadeType.ALL)
	
	private  Order order;
	private int itemId;
	private int quantity;
	public int getOrderItem() {
		return orderItemId;
	}
	public void setOrderItem(int orderItem) {
		this.orderItemId = orderItem;
	}
	public Order getOrderId() {
		return order;
	}
	public void setOrderId(Order order) {
		this.order = order;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
