package com.example.demoProject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demoProject.model.Order;
import com.example.demoProject.model.OrderItem;
import com.example.demoProject.service.OrderRepository;

@SpringBootApplication
public class DemoProjectApplication {

	@Autowired
	OrderRepository orderRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
		
		
		System.out.println("Hello	");
		
	}
	
	/*
	 * @Override public void run(String...args) { Order order= new Order();
	 * Set<OrderItem> itemList = new HashSet<OrderItem>(); itemList.add(new
	 * OrderItem(1,10)); order.setOrderItem(itemList); order.setCustomerId(1);
	 * order.setgTotal(100); order.setOrderNo("214536"); order.setPayMethod("card");
	 * orderRepo.save(order); }
	 */
}
