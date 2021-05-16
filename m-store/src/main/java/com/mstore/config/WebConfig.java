package com.mstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Access static resource:
		// Ex: http://domain/js/
		registry.addResourceHandler("/js/**") //
				.addResourceLocations("classpath:/static/public/js/");

		// css
		registry.addResourceHandler("/css/**") //
				.addResourceLocations("classpath:/static/public/css/");

		// img
		registry.addResourceHandler("/assets/**") //
				.addResourceLocations("classpath:/static/public/assets/");

		// vendor
		registry.addResourceHandler("/vendor/**") //
				.addResourceLocations("classpath:/static/public/vendor/");

	}
}