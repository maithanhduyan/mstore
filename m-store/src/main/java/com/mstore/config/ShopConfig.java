/**
 * @author Mai Thành Duy An
 */
package com.mstore.config;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.mstore.entities.Shop;
import com.mstore.repositories.ShopRepository;
import com.mstore.services.AppService;
import com.mstore.services.ShopService;

@Configuration
public class ShopConfig {

	@Autowired
	private Environment env;
	
	private static final Logger log = LoggerFactory.getLogger(ShopConfig.class);
	private static Shop _shop = null;

	@Value("${shop.name}")
	String _shopName;
	
	@Value("${shop.domain.name}")
	String _shopDomainName;
	
	
	@Autowired 
	ShopRepository shopRepository;

	@Bean
	public Shop initialShop() {
		if (_shop == null) {
			_shop = new Shop();
			_shop.setId(UUID.randomUUID().toString());
			_shop.setName(env.getProperty("shop.name","Mstore"));
			AppService.context.put("shop", _shop);
		}
		AppService.context.put("url",_shopDomainName);
		log.info("Initial Shop Config. " + AppService.context + " . " + AppService.context.size());
		log.info(""+shopRepository.count());
		return null;
	}
}
