package com.example.demoProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoProject.model.Customer;
import com.example.demoProject.model.ItemDto;
import com.example.demoProject.model.Order;
import com.example.demoProject.model.OrderItem;
import com.example.demoProject.service.RestaurantService;

@RestController
public class RestaurantController {
	
	@Autowired
	RestaurantService service;
	
	@RequestMapping(value="/addCustomer" , method = RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer) {
		service.addCustomer(customer);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/getAllCustomer" , method = RequestMethod.GET)
	public List<Customer> getAllCustomer() {
		
		return service.getAllCustomer();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/getAllItems" , method = RequestMethod.GET)
	public List<ItemDto> getAllItems() {
		
		return service.getAllItems();
	}
	
	@RequestMapping(value="/addItem" , method = RequestMethod.POST)
	public void addItem(@RequestBody ItemDto item) {
		service.addItem(item);
	}
	@RequestMapping(value="/postOrder" , method = RequestMethod.POST)
	public void postOrder(@RequestBody Order order) {
		service.postOrder(order);	
	}
	@RequestMapping(value="/postOrderItem" , method = RequestMethod.POST)
	public void postOrderItem(@RequestBody OrderItem order) {
		service.postOrder(order);	
	}
	@RequestMapping(value="/getOrders" , method = RequestMethod.GET)
	public List<Order> getOrders() {
		
		return service.getOrders();
	}
	@RequestMapping(value="/getOrderItems" , method = RequestMethod.GET)
	public List<OrderItem> getOrderItemsByOrderId() {
		
		return service.getOrderItemsByOrderId();
	}
}
