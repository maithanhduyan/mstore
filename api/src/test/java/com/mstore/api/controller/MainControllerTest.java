/**
 * @author Mai Thành Duy An
 */
package com.mstore.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mstore.controller.MainController;
import com.mstore.entities.Product;
import com.mstore.repositories.EmployeeRepository;
import com.mstore.repositories.ProductRepository;
import com.mstore.services.ProductService;

@RestController
public class MainControllerTest {

	Logger log = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Product> showAllProduct() {
		Long start = System.currentTimeMillis();
		List<Product> list = null;
		list = this.productRepository.findAll();
		Long duration = System.currentTimeMillis() - start;
		log.info("Take: " + duration + "ms");
		return list;
	}
}
