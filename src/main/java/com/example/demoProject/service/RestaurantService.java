package com.example.demoProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoProject.model.Customer;
import com.example.demoProject.model.ItemDto;
import com.example.demoProject.model.Order;
import com.example.demoProject.model.OrderItem;
import com.example.demoProject.repo.CustomerRepository;
import com.example.demoProject.repo.ItemRepository;



@Service
public class RestaurantService {

	@Autowired
	
	CustomerRepository custRepo;
	
	@Autowired 
	
	ItemRepository itemRepo;
	
	@Autowired
	
	OrderRepository orderRepo;
	
	@Autowired
	
	OrderItemRepository orderItemRepo;
	
	public void addCustomer(Customer cust) {
	
		custRepo.save(cust);
	}

	public List<Customer> getAllCustomer() {
		List<Customer> custList= new ArrayList<Customer>();
		custRepo.findAll().forEach(custList::add);
		return custList;
		
		
	}

	public List<ItemDto> getAllItems() {
		// TODO Auto-generated method stub
		List<ItemDto> itemList= new ArrayList<ItemDto>();
		itemRepo.findAll().forEach(itemList::add);
		return itemList;
	}

	public void addItem(ItemDto it) {
		// TODO Auto-generated method stub
		itemRepo.save(it);
	}

	public void postOrder(Order order) {
		// TODO Auto-generated method stub
		
		 orderRepo.save(order);
	}
	public void postOrder(OrderItem order) {
		// TODO Auto-generated method stub
		
		 orderItemRepo.save(order);
	}

	public List<Order> getOrders() {
		List<Order> orderList= new ArrayList<Order>();
		orderRepo.findAll().forEach(orderList::add);
		return orderList;
		
	}

	public List<OrderItem> getOrderItemsByOrderId() {
		// TODO Auto-generated method stub
		List<OrderItem> orderList= new ArrayList<OrderItem>();
		orderItemRepo.findAll().forEach(orderList::add);
		//orderItemRepo.findByOrderId(orderId).forEach(orderList::add);
		return orderList;
	}
}
