package com.example.demoProject.service;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;



import com.example.demoProject.model.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

	Set<OrderItem> findByOrderId(int i);

	void deleteByOrderId(Integer i);

	//List<OrderItem> findByOrderId(int orderId);

}
