package com.example.demoProject.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demoProject.model.ItemDto;

public interface ItemRepository extends CrudRepository<ItemDto,Integer>{

}
