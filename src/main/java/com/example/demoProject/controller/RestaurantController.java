package com.example.demoProject.controller;

import java.util.ArrayList;
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
import com.example.demoProject.model.OrderDetailsDto;
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
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/postOrder" , method = RequestMethod.POST)
	public void postOrder(@RequestBody Order order) {
		Order savedorder = service.postOrder(order);
		for(OrderItem item:order.getOrderItem()){
			item.setOrderId(savedorder.getOrderId());
			service.postOrder(item);
		}
		for(Integer i:order.getDeletedOrderItemIds()){
			//service.deleteOrder(i);
			service.deleteOrderItem(i);
		}
		
			
	}
	@RequestMapping(value="/postOrderItem" , method = RequestMethod.POST)
	public void postOrderItem(@RequestBody OrderItem order) {
		service.postOrder(order);	
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/getOrders" , method = RequestMethod.GET)
	public List<Order> getOrders() {
		
		return service.getOrders();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/getOrderById/{orderId}" , method = RequestMethod.GET)
	public OrderDetailsDto getOrderById(@PathVariable ("orderId") int orderId) {
		
		OrderDetailsDto orderItem= new OrderDetailsDto();
		for(Order o:service.getOrders()){
			if(o.getOrderId()==orderId)
				orderItem.setOrder(o);
		}
		orderItem.setOrderItemList(service.getOrderItemsByOrderId(orderId));
		return orderItem;
	}
	@RequestMapping(value="/getOrderItems" , method = RequestMethod.GET)
	public List<OrderItem> getOrderItemsByOrderId() {
		
		return service.getOrderItemsByOrderId();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/deleteOrder/{orderId}" , method = RequestMethod.DELETE)
	public void deleteOrderByOrderId(@PathVariable ("orderId") int orderId) {
		
		 service.deleteOrderItemByOrderId(orderId);
		 service.deleteOrder(orderId);
	}
}
