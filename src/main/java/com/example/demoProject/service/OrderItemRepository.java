package com.example.demoProject.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.demoProject.model.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

	//List<OrderItem> findByOrderId(int orderId);

}
