package com.springboot.inventory.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer order_id;
	private Integer item_id;
	private Integer quantity;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Date;

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getItem_id() {
		return item_id;
	}

	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", item_id=" + item_id + ", quantity=" + quantity + ", Date=" + Date
				+ "]";
	}

	public Orders(Integer order_id, Integer item_id, Integer quantity, java.util.Date date) {
		super();
		this.order_id = order_id;
		this.item_id = item_id;
		this.quantity = quantity;
		Date = date;
	}

}
