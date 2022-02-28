package com.springboot.inventory.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.inventory.entity.Item;
import com.springboot.inventory.entity.Orders;
import com.springboot.inventory.jpa.repo.ItemRepository;
import com.springboot.inventory.jpa.repo.OrderRepository;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	OrderRepository orderRepository;

	@GetMapping("/addorders")
	public String addOrder(Model model) {
		model.addAttribute("orders", new Orders());
		model.addAttribute("items", itemRepository.findAll());
		return "add_order";
	}

	@GetMapping("/allOrders")
	public String showAllOrders(Model model) {
		List<Orders> list=orderRepository.findAll();
		System.out.println("list of items :" + list);
		model.addAttribute("orders", list);
		return "all_orders";
	}
	
	@PostMapping("/processOrder")
	public String processItem(@ModelAttribute Orders order) {
		System.out.println("order : "+order);
		orderRepository.save(order);
		return "redirect:/order/addorders";
	}
	
	@PostMapping("/saveOrders")
	public String saveOrder(@ModelAttribute Orders order,RedirectAttributes redirAttrs,Model model)
	{
		Item item=itemRepository.getById(order.getItem_id());
		System.out.println("item :"+item);
		System.out.println("order :"+order);
		Integer stock=item.getStock();
		Integer quantity=order.getQuantity();
		if(quantity<=stock)
		{
			stock=stock-quantity;
			item.setStock(stock);
			System.out.println("order : "+order);
			System.out.println("item : "+item);
			itemRepository.save(item);
			orderRepository.save(order);
			redirAttrs.addFlashAttribute("success","Order Created Successfully");
			return "redirect:/order/addorders";
		}
		else {
			//model.addAttribute("alert","Error Quantity Cannot be greater then the current stock");
			//model.addAttribute("alertClass", "alert-danger");
			redirAttrs.addFlashAttribute("error","Error Quantity Cannot be greater then the current stock");

			return "redirect:/order/addorders";
		}
		
	}
	
}
