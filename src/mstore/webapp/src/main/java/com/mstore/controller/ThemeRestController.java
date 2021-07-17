package com.mstore.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mstore.domain.product.repository.ProductCategoryRepository;

@RestController
public class ThemeRestController {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(ThemeRestController.class);

	@Autowired
	ProductCategoryRepository pCategoryRepository;

	@SuppressWarnings("unused")
	@RequestMapping(value = "/theme/productCategories", method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, Object> getProductCategories(@RequestParam HashMap<String, String> requestData) {
		String productId = requestData.get("productId");
		Map<String, Object> responseData = new HashMap<>();

		return responseData;
	}
}
