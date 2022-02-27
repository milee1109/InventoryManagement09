package com.springboot.inventory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer item_id;

	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	private String description;
	private Integer stock;
	private Double price;

	public Item() {
		super();
	}

	public Item(String description, Integer stock, Double price) {
		super();
		this.description = description;
		this.stock = stock;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", description=" + description + ", stock=" + stock + ", price=" + price
				+ "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}