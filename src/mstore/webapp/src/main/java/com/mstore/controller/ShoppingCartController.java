package com.mstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mstore.domain.product.service.ProductCategoryService;
import com.mstore.domain.product.service.ProductService;
import com.mstore.domain.sales.entity.OrderDetail;
import com.mstore.model.CartMessage;
import com.mstore.model.ChatMessage;
import com.mstore.utils.Cart;

@Controller
public class ShoppingCartController {

	private static final Logger LOG = LoggerFactory.getLogger(ShoppingCartController.class);

	@Autowired
	ProductService productService;

	@Autowired
	Cart cart;

	@Autowired
	ProductCategoryService productCategoryService;

	@RequestMapping(value = "/cart.html", method = RequestMethod.GET)
	public String viewCart(Model model) {
		model.addAttribute("message", "Mini Store");
		model.addAttribute("cart_size", cart.getCounter());
		model.addAttribute("orderDetails", cart.getOrderDetails());
		model.addAttribute("totalAmount", cart.getTotalAmount());
		model.addAttribute("productCategories", productCategoryService.findAll());
		return "shopping_cart";
	}

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/publicChatRoom")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}

	@MessageMapping("/cart.sendMessage")
	@SendTo("/topic/publicChatRoom")
	public CartMessage sendCartMessage(@Payload CartMessage cartMessage) {
		return cartMessage;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/publicChatRoom")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		// Add username in web socket session
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
}
