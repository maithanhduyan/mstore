/**
 * @author Mai Thành Duy An
 */
package com.mstore.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mstore.entities.ShoppingCart;
import com.mstore.entities.ShoppingCartItem;
import com.mstore.repositories.humanresource.UserRepository;

@RestController
public class ShoppingCartRestController {

	private static final Logger log = LoggerFactory.getLogger(ShoppingCartRestController.class);

	@Autowired
	UserRepository userRepository;
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
		log.info("" + cartItem.toString());
		log.info("" + requestData.toString());
		log.info("" + requestData.get("data"));
		log.info("" + dataResponse.toString());

		return "OK";
	}
}
