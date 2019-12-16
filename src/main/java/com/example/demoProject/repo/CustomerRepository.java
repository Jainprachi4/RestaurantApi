package com.example.demoProject.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demoProject.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>  {

}
