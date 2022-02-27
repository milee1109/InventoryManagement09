package com.springboot.inventory.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.inventory.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
