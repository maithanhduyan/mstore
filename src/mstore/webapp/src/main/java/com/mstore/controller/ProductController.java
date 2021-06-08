package com.mstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mstore.domain.product.entity.Product;
import com.mstore.domain.product.repository.ProductRepository;
import com.mstore.domain.product.service.ProductCategoryService;
import com.mstore.domain.product.service.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	private static Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	ProductCategoryService productCategoryService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getProduct(@PathVariable("id") String id, Model model) {
		Product product = null;
		try {
			if (id != null) {
				product = productService.findById(id);
				log.info(product.toString());

				model.addAttribute("productCategories", productCategoryService.findAll());
			}
		} catch (Exception ex) {
			// TODO: handle exception
			log.info("Error: " + ex.getMessage());
		}
		model.addAttribute("product", product);
		return "product_detail";
	}

}
