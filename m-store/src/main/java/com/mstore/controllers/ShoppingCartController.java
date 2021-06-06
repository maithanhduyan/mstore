/**
 * @author Mai Thành Duy An
 */
package com.mstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/cart")
public class ShoppingCartController {

	@RequestMapping(value = {"/",".html"})
	public String viewCart() {
		return "shopping_cart";
	}
}
