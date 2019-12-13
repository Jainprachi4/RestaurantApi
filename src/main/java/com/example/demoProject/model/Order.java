package com.example.demoProject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//insert into order (customer_id, g_total, order_no, pay_method, order_id) values (?, ?, ?, ?, ?)
@Entity
@Table (name="Order_Table")
public class Order {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_Id")
	private int orderId;
	private String orderNo;
	private int customerId;
	private String payMethod;
	private double gTotal;
	@OneToMany(cascade = CascadeType.MERGE)
	public Set<OrderItem> orderItem = new HashSet<OrderItem> ();
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public double getgTotal() {
		return gTotal;
	}
	public void setgTotal(double gTotal) {
		this.gTotal = gTotal;
	}
	public Set<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(Set<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	
	
	
}
