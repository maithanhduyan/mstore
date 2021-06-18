package com.mstore.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mstore.domain.product.entity.Product;
import com.mstore.domain.product.repository.ProductRepository;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductRestController {

	private static final Logger LOG = LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	ProductRepository productRepository;

	@RequestMapping(value = "/version", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public String getVersion() {
		return "v1";
	}

	@RequestMapping(value = "/fetchById", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Product getProductById(@RequestParam Map<String, String> data) {
		LOG.info("" + data.get("id"));
		LOG.info("" + productRepository.findById(data.get("id")).orElse(null));
		//Product product = Product.getInstance();
		 Product product = productRepository.findById(data.get("id")).orElse(null);
		LOG.info("" + product.toString());
		return product;
	}

	@RequestMapping(value = "/productList", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public List<Product> getList() {
		return productRepository.findAll();
	}
}
