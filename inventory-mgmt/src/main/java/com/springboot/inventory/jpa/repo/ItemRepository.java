package com.springboot.inventory.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.inventory.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
