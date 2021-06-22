package com.mstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private Environment env;

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
				registry.addMapping("/api**").allowedOrigins("http://localhost:8080");
				registry.addMapping("/ws**").allowedOrigins("http://localhost:8080");
				registry.addMapping("/api**").allowedOrigins("http://nijimise.com");
				registry.addMapping("/ws**").allowedOrigins("http://nijimise.com");
			}
		};
	}

//	@Bean(name = "dataSource")
//	public DataSource getDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//		// See: application.properties
//		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//		dataSource.setUrl(env.getProperty("spring.datasource.url"));
//		dataSource.setUsername(env.getProperty("spring.datasource.username"));
//		dataSource.setPassword(env.getProperty("spring.datasource.password"));
//
//		System.out.println("## getDataSource: " + dataSource);
//
//		return dataSource;
//	}

//	@Autowired
//	@Bean(name = "sessionFactory")
//	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
//		Properties properties = new Properties();
//
//		// See: application.properties
//		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
//		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
//		properties.put("current_session_context_class", //
//				env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
//
//		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//
//		// Package contain entity classes
//		factoryBean.setPackagesToScan(new String[] { "" });
//		factoryBean.setDataSource(dataSource);
//		factoryBean.setHibernateProperties(properties);
//		factoryBean.afterPropertiesSet();
//		//
//		SessionFactory sf = factoryBean.getObject();
//		System.out.println("## getSessionFactory: " + sf);
//		return sf;
//	}
//
//	@Autowired
//	@Bean(name = "transactionManager")
//	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//
//		return transactionManager;
//	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		// Load file: validation.properties
		messageSource.setBasename("classpath:validation");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}
