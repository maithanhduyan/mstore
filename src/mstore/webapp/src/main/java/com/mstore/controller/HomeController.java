package com.mstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mstore.domain.product.entity.Product;
import com.mstore.domain.product.service.ProductCategoryService;
import com.mstore.domain.product.service.ProductService;

@Controller
public class HomeController {
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	ProductService productService;

	@Autowired
	ProductCategoryService productCategoryService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		long start = System.currentTimeMillis();
		model.addAttribute("message", "Mini Store");
		List<Product> products = productService.findAll();
		LOG.info("" + products.size());
		model.addAttribute("products", products);
		model.addAttribute("productCategories", productCategoryService.findAll());

		LOG.info("Take: " + (System.currentTimeMillis() - start) + " ms");
		return "index";
	}
}
