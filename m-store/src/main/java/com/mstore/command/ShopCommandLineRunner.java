/**
 * @author Mai Thành Duy An
 */
package com.mstore.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ShopCommandLineRunner implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(ShopCommandLineRunner.class);

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("Initial Shop Info");
	}

}
