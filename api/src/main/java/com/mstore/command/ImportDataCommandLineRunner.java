/**
 * @author Mai Thành Duy An
 */
package com.mstore.command;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mstore.entities.Employee;
import com.mstore.entities.Product;
import com.mstore.repositories.ProductRepository;

@Component
public class ImportDataCommandLineRunner implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(ImportDataCommandLineRunner.class);

	@Autowired
	private ProductRepository repository;

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < args.length; i++) {
			log.info(args[i].toString());
			if (args[i].toString().equalsIgnoreCase("--DataSample=true")) {
				insertProductDataSample();
				break;
			}

		}
	}

	// Insert Product Function
	int insertProductDataSample() {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			Product p = new Product();
			p.setId(UUID.randomUUID().toString());
			int code = new Random().nextInt(200000);
			p.setCode("CODE-" + code);
			p.setCostPrice(new Random().nextInt(200000));
			p.setActive(1);
			p.setCreatedDate(new Date());
			this.repository.save(p);
		}
		Long duration = System.currentTimeMillis() - start;
		log.debug("Insert Sample Product Data." + " (" + duration + "ms)");
		return 1;
	}

	int insertEmployeeDataSample() {
		// Employee
		for (int i = 0; i < 10; i++) {
			Employee employee = new Employee();
			employee.setEmpNo(UUID.randomUUID().toString());
			employee.setFullName("");
			employee.setHireDate(new Date());
			employee.setId(new Random().nextLong());
		}
		return 1;
	}

}
