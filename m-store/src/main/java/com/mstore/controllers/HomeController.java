package com.mstore.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mstore.entities.Product;
import com.mstore.services.ProductCategoryService;
import com.mstore.services.ProductService;

@Controller
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	ProductService productService;
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	private static String _version = "v1";

	@RequestMapping(value = { "/","/index.html" })
	public String getHomPage(Model model) {
		long start = System.currentTimeMillis();
		model.addAttribute("message", "Mini Store");
		List<Product> products = productService.findAll();
		log.info("" + products.size());
		model.addAttribute("products", products);
		model.addAttribute("productCategories", productCategoryService.findAll());

		log.info("Take: " + (System.currentTimeMillis() - start) + " ms");
		return "index";
	}

	@RequestMapping(value = { "/v1" })
	public String getHomPageV2(Model model) {
		model.addAttribute("message", "Mini Store");
		List<Product> products = productService.findAll();
		log.info("" + products.size());
		model.addAttribute("products", products);
		return "shop_" + _version;
	}
}
