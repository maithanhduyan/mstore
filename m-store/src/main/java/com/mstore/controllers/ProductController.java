package com.mstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mstore.repositories.ProductRepository;
import com.mstore.services.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	@ResponseBody
	public String getProduct() {
		System.out.println(productService.count());
		return "Product count: "+productService.count();
	}

}
