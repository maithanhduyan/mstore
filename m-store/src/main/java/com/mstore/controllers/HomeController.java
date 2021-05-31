package com.mstore.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mstore.entities.Product;
import com.mstore.services.ProductService;

@Controller
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	ProductService productService;

	@RequestMapping(value = { "/" })
	public String getHomPage(Model model) {
		model.addAttribute("message", "Mini Store");
		List<Product> products = productService.findAll();
		log.info("" + products.size());
		model.addAttribute("products", products);
		return "index";
	}
}
