package com.example.demoProject.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoProject.model.Customer;
import com.example.demoProject.model.ItemDto;
import com.example.demoProject.model.Order;
import com.example.demoProject.model.OrderItem;
import com.example.demoProject.repo.CustomerRepository;
import com.example.demoProject.repo.ItemRepository;


@Transactional
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
		 
		List<ItemDto> itemList= new ArrayList<ItemDto>();
		itemRepo.findAll().forEach(itemList::add);
		return itemList;
	}

	public void addItem(ItemDto it) {
		 
		itemRepo.save(it);
	}

	public Order postOrder(Order order) {
		 
		return orderRepo.save(order);
	}
	
	public void postOrder(OrderItem order) {
		  orderItemRepo.save(order);
	}

	public List<Order> getOrders() {
		List<Order> orderList= new ArrayList<Order>();
		Set<OrderItem> orderItemList= new HashSet<OrderItem>();
		orderRepo.findAll().forEach(orderList::add);
		for(Order order: orderList){
			Set<Customer> custList=findCustomer();
			for(Customer cust: custList){
				if(cust.getCustomerId()==order.getCustomerId()){
					order.setCustomerName(cust.getCustomerName());
				}
			}
			orderItemRepo.findByOrderId(order.getOrderId()).forEach(orderItemList::add);
		}
		return orderList;
		
	}

	private Set<Customer> findCustomer() {
		Set<Customer> customers= new HashSet<Customer>();
		 
		custRepo.findAll().forEach(customers::add);
		return customers;
	}

	
	public Set<OrderItem> getOrderItemsByOrderId(int orderId) {
		 List<ItemDto> items = new ArrayList<ItemDto>();
		Set<OrderItem> orderList= new HashSet<OrderItem>();
		orderItemRepo.findByOrderId(orderId).forEach(orderList::add);
		itemRepo.findAll().forEach(items::add);
		for(OrderItem o:orderList){
			for(ItemDto item:items){
				if(item.getItemId()==o.getItemId()){
					o.setItemName(item.getItemName());
					o.setPrice(item.getPrice());
				}
			}
		}
		return orderList;
	}

	public void deleteOrder(Integer i) {
		orderRepo.deleteById(i);
	}
	
	public void deleteOrderItem(Integer i) {
		orderItemRepo.deleteById(i);
	}
	
	public void deleteOrderItemByOrderId(Integer i) {
		orderItemRepo.deleteByOrderId(i);
	}
}
