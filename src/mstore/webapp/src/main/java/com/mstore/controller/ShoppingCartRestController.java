package com.mstore.controller;

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

import com.mstore.domain.product.repository.ProductRepository;
import com.mstore.domain.sales.entity.OrderDetail;
import com.mstore.domain.sales.entity.ShoppingCart;
import com.mstore.domain.sales.entity.ShoppingCartItem;
import com.mstore.utils.Cart;

@RestController
@CrossOrigin(origins = { "http://localhost:8080", "http://nijimise.com" })
public class ShoppingCartRestController {

	private static final Logger LOG = LoggerFactory.getLogger(ShoppingCartRestController.class);

	ShoppingCartItem cartItem;
	ShoppingCart shoppingCart;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	Cart cart;

	@RequestMapping(value = "/cart/add", method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, Object> addToCart(@RequestParam HashMap<String, String> requestData) {
		String productId = requestData.get("productId");
		Map<String, Object> responseData = new HashMap<>();
		cartItem = ShoppingCartItem.getInstance();
		if (!productId.equalsIgnoreCase(null)) {
			cart.addToCart(productId);
			responseData.put("counter", cart.getCounter());
		}

		return responseData;
	}

	@RequestMapping(value = "/cart/increaseQuantity", method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, Object> increase(@RequestParam HashMap<String, String> requestData) {
		String productId = requestData.get("productId");
		String command = requestData.get("command");
		Map<String, Object> responseData = new HashMap<String, Object>();
		if (!productId.equalsIgnoreCase(null) && command.equalsIgnoreCase("increaseQuantity")) {
			cart.increaseQuantity(productId);
			OrderDetail orderDetail = cart.getOrderDetailById(productId);
			responseData.put("quantity", orderDetail.getQuantity());
			responseData.put("amount", orderDetail.getAmount());
		}
		return responseData;
	}

	@RequestMapping(value = "/cart/decreaseQuantity", method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, Object> decrease(@RequestParam HashMap<String, String> requestData) {
		String productId = requestData.get("productId");
		String command = requestData.get("command");
		Map<String, Object> responseData = new HashMap<String, Object>();
		try {
			if (!productId.equalsIgnoreCase(null) && command.equalsIgnoreCase("decreaseQuantity")) {
				int result = cart.decreaseQuantity(productId);
				OrderDetail orderDetail = cart.getOrderDetailById(productId);
				if (result == 1) {
					responseData.put("quantity", orderDetail.getQuantity());
					responseData.put("amount", orderDetail.getAmount());
				} else {
					responseData.put("amount", 0);
					responseData.put("quantity", 0);
				}
			}
		} catch (Exception ex) {
			LOG.info(ex.getMessage());
		}
		return responseData;
	}

	@RequestMapping(value = "/cart/remove", method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, Object> removeProduct(@RequestParam HashMap<String, String> requestData) {
		String productId = requestData.get("productId");
		String command = requestData.get("command");
		Map<String, Object> responseData = new HashMap<>();
		if (!productId.equalsIgnoreCase(null) && command.equalsIgnoreCase("removeProduct")) {
			cart.removeProduct(productId);
			responseData.put("counter", cart.getCounter());
		}

		return responseData;
	}

	@RequestMapping(value = "/cart/getTotalAmount", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, Object> getTotalAmount(@RequestParam HashMap<String, String> requestData) {
		String command = requestData.get("command");
		Map<String, Object> responseData = new HashMap<String, Object>();
		if (command.equalsIgnoreCase("getTotalAmount")) {
			responseData.put("totalAmount", cart.getTotalAmount());
		}

		return responseData;
	}

	@RequestMapping(value = "/cart/shippingFee", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, Object> getShippingFee(@RequestParam HashMap<String, String> requestData) {
		String command = requestData.get("command");
		Map<String, Object> responseData = new HashMap<>();
		if (command.equalsIgnoreCase("getShippingFee")) {
			responseData.put("shippingFee", 123);
		}

		return responseData;
	}

	@RequestMapping(value = "/cart/counter", method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public int cartSize(@RequestParam HashMap<String, String> requestData) {
		if (requestData.get("command").equalsIgnoreCase("getCartCounter")) {
			return cart.getCounter();
		}
		return 0;
	}
}
