package com.mstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
				.addResourceLocations("classpath:/static/js/");

		// css
		registry.addResourceHandler("/css/**") //
				.addResourceLocations("classpath:/static/css/");

		// img
		registry.addResourceHandler("/assets/**") //
				.addResourceLocations("classpath:/static/assets/");

		// vendor
		registry.addResourceHandler("/vendor/**") //
				.addResourceLocations("classpath:/static/vendor/");

	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080");
			}
		};
	}
}