package com.example.demoProject.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demoProject.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
