package com.example.demoProject.model;

import java.util.HashSet;
import java.util.Set;

public class OrderDetailsDto {

	private Order order;
	private Set<OrderItem> orderItemList= new HashSet<OrderItem>();
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Set<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(Set<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
}
