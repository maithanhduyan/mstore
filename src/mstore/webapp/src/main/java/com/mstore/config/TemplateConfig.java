package com.mstore.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mstore.domain.product.entity.ProductCategory;
import com.mstore.domain.product.repository.ProductCategoryRepository;

@Configuration
public class TemplateConfig {

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@ModelAttribute("categories")
	public List<ProductCategory> getCategoryList() {
		List<ProductCategory> list = productCategoryRepository.findAll();
		return list;
	}
	
	@Bean
	public String getDomainName() {
		return "localhost:8080";
	}
}
