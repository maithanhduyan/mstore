package com.mstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mstore.domain.product.service.ProductCategoryService;
import com.mstore.domain.product.service.ProductService;

@Controller
public class ShoppingCartController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ShoppingCartController.class);

	@Autowired
	ProductService productService;

	@Autowired
	ProductCategoryService productCategoryService;

	@RequestMapping(value = "/cart.html", method = RequestMethod.GET)
	public String viewCart(Model model) {
		model.addAttribute("message", "Mini Store");
		model.addAttribute("productCategories", productCategoryService.findAll());
		return "shopping_cart";
	}
}
