package com.springboot.inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.inventory.entity.Item;
import com.springboot.inventory.jpa.repo.ItemRepository;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/add")
	public String insertItemHandler(Model model) {
		model.addAttribute("item", new Item());
		return "add_item";
	}
	
	@PostMapping("/processItem")
	public String processItem(@ModelAttribute Item item) {
		System.out.println("item : "+item);
		this.itemRepository.save(item);
		return "redirect:/item/add";
	}
	
	@GetMapping("/all-items")
	public String listAllItems(Model model) {
		List<Item> allItems = this.itemRepository.findAll();
		System.out.println("list of items :" + allItems);
		model.addAttribute("items", allItems);
		return "items-catalog";
	}


}
