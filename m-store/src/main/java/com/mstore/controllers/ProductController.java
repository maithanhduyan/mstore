package com.mstore.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mstore.entities.Product;
import com.mstore.repositories.ProductRepository;
import com.mstore.services.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	private static Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getProduct(@PathVariable("id") String id, Model model) {
		Product product = null;
		try {
			if (id != null) {
				product = productService.findById(id);
				log.info(product.toString());
			}
		} catch (Exception ex) {
			// TODO: handle exception
			log.info("Error: " + ex.getMessage());
		}
		model.addAttribute("product", product);
		return "product_detail";
	}

}
