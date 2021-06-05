/**
 * @author Mai Thành Duy An
 */
package com.mstore.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// csv
		registry.addResourceHandler("/csv/**") //
				.addResourceLocations("classpath:/static/assets/data/csv");

	}
}
