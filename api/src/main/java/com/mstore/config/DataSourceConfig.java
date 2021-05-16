/**
 * @author Mai Thành Duy An
 */
package com.mstore.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DataSourceConfig {
	@Autowired
	private Environment env;
	private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);
//	@Bean
//	public DataSource getH2DataSource() {
//		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//		dataSourceBuilder.driverClassName(env.getProperty("jdbc.driverClassName", "org.h2.Driver"));
//		dataSourceBuilder.url(env.getProperty("jdbc.url", "jdbc:h2:mem:test"));
//		dataSourceBuilder.username(env.getProperty("jdbc.user", "SA"));
//		dataSourceBuilder.password(env.getProperty("jdbc.pass", ""));
//		return dataSourceBuilder.build();
//	}
	
	@Bean
	public String initDeafaultBean() {
		log.info("Initialize Deafault Bean");
		return "";
	}
}
