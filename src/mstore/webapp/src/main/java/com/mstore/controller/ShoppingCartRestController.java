package com.mstore.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mstore.domain.sales.entity.ShoppingCart;
import com.mstore.domain.sales.entity.ShoppingCartItem;

@RestController
public class ShoppingCartRestController {

	private static final Logger LOG = LoggerFactory.getLogger(ShoppingCartRestController.class);

	ShoppingCartItem cartItem;
	ShoppingCart shoppingCart;

	// http://localhost:8080/cart/add
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = "/cart/add", method = RequestMethod.POST, //
			// consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public String addToCart(@RequestParam HashMap<String, String> requestData) {
		Map<String, Object> dataResponse = new HashMap<String, Object>();
		cartItem = ShoppingCartItem.getInstance();
		LOG.info("" + cartItem.toString());
		LOG.info("" + requestData.toString());
		LOG.info("" + requestData.get("data"));
		LOG.info("" + dataResponse.toString());

		return "OK";
	}
}
