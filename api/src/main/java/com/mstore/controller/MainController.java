package com.mstore.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mstore.entities.Currency;
import com.mstore.entities.Employee;
import com.mstore.entities.Product;
import com.mstore.entities.Shop;
import com.mstore.repositories.CurrencyRepository;
import com.mstore.repositories.ProductRepository;
import com.mstore.repositories.ShopRepository;
import com.mstore.repositories.humanresource.EmployeeRepository;
import com.mstore.services.ProductService;

@Controller
public class MainController {

	static final Logger LOG = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private CurrencyRepository currencyRepository;

	@Autowired
	private ShopRepository shopRepository;

	@ResponseBody
	@RequestMapping("/")
	public String home() {
		String html = "";
		html += "<ul>";
		html += " <li><a href='/test/InsertEmployee'>Test Insert</a></li>";
		html += " <li><a href='/test/showAllEmployee'>Show All Employee</a></li>";
		html += " <li><a href='/test/showFullNameLikeTom'>Show All 'Tom'</a></li>";
		html += " <li><a href='/test/deleteAllEmployee'>Delete All Employee</a></li>";
		html += " <li><a href='/test/addProduct'>Add Product</a></li>";
		html += " <li><a href='/test/showAllProduct'>Show All Product</a></li>";
		html += " <li><a href='/test/showAllProduct.json'>Show All Product JSON</a></li>";
		html += " <li><a href='/test/showAllCurrency'>Show All Currency</a></li>";
		html += " <li><a href='/test/showShopInfo'>Show Shop Info</a></li>";
		html += "</ul>";
		return html;
	}

	@ResponseBody
	@RequestMapping("/test/InsertEmployee")
	public String testInsert() {
		String[] lastName = { "Lê", "Nguyễn", "Mai", "Võ", "Trần", "Phan", "Trịnh" };
		String[] sampleNames = { "Nam", "An", "Tài", "Võ", "Đức", "Tiến", "Minh", "Trí", "Thiện", "Tâm" };
		Long start = System.currentTimeMillis();

		Employee employee = new Employee();

		String id = UUID.randomUUID().toString();
		String name = sampleNames[new Random().nextInt(10)];
		String fullName = lastName[new Random().nextInt(7)].toString() + " " + name;

		employee.setId(id);
		employee.setName(name);
		employee.setFullName(fullName);
		employee.setHireDate(new Date());
		employee.setCreatedDate(new Date());
		this.employeeRepository.save(employee);

		LOG.debug(employee.toString());

		Long duration = System.currentTimeMillis() - start;
		LOG.debug("Take: " + duration + "ms");
		return "Inserted: " + employee;
	}

	@ResponseBody
	@RequestMapping("/test/showAllEmployee")
	public String showAllEmployee() {

		Long start = System.currentTimeMillis();
		Iterable<Employee> employees = this.employeeRepository.findAll();

		String html = "";
		for (Employee emp : employees) {
			html += emp + "<br>";
		}
		Long duration = System.currentTimeMillis() - start;
		LOG.debug("Take: " + duration + "ms");
		return html;
	}

	@ResponseBody
	@RequestMapping("/test/showFullNameLikeTom")
	public String showFullNameLikeTom() {

		Long start = System.currentTimeMillis();
		List<Employee> employees = this.employeeRepository.findByFullNameLike("Tom");

		String html = "";
		for (Employee emp : employees) {
			html += emp + "<br>";
		}
		Long duration = System.currentTimeMillis() - start;
		LOG.debug("Take: " + duration + "ms");
		return html;
	}

	@ResponseBody
	@RequestMapping("/test/deleteAllEmployee")
	public String deleteAllEmployee() {
		Long start = System.currentTimeMillis();
		this.employeeRepository.deleteAll();
		Long duration = System.currentTimeMillis() - start;
		LOG.debug("Take: " + duration + "ms");
		return "Deleted!";
	}

	@ResponseBody
	@RequestMapping("/test/addProduct")
	public String addProduct() {
		Long start = System.currentTimeMillis();
		String id = UUID.randomUUID().toString();
		Product product = Product.getInstance();
		product.setId(id);
		int code = new Random().nextInt(200000);
		product.setCode("C" + code);
		product.setActive(1);
		product.setCreatedDate(new Date());
		this.productRepository.save(product);
		Long duration = System.currentTimeMillis() - start;
		LOG.debug("Take: " + duration + "ms");
		return "Inserted: " + this.productRepository.findById(id);
	}

	@ResponseBody
	@RequestMapping("/test/showAllProduct")
	public String showAllProduct() {
		Long start = System.currentTimeMillis();
		Iterable<Product> product = this.productRepository.findAll();

		String html = "";
		for (Product p : product) {
			html += p + "<br>";
		}
		Long duration = System.currentTimeMillis() - start;
		LOG.debug("Take: " + duration + "ms");
		return "Take:" + duration + " ms <br>" + html;
	}

	@ResponseBody
	@RequestMapping(value = "/test/showAllProduct.json", method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Product> showAllProductJson() {
		Long start = System.currentTimeMillis();
		List<Product> list = null;
		list = this.productRepository.findAll();
		Long duration = System.currentTimeMillis() - start;
		LOG.debug("Take: " + duration + "ms");
		return list;
	}

	@ResponseBody
	@RequestMapping("/test/showAllCurrency")
	public String showAllCurrency() {
		Long start = System.currentTimeMillis();
		Iterable<Currency> currency = this.currencyRepository.findAll();

		String html = "";
		for (Currency c : currency) {
			html += c + "<br>";
		}
		Long duration = System.currentTimeMillis() - start;
		LOG.debug("Take: " + duration + "ms");
		return "Take:" + duration + " ms <br>" + html;
	}

	@ResponseBody
	@RequestMapping("/test/showShopInfo")
	public String showShopInfo() {
		Long start = System.currentTimeMillis();
		LOG.info("" + shopRepository.findAll().size());
		List<Shop> shops = shopRepository.findAll();

		String html = "";
		for (Shop s : shops) {
			html += s + "<br>";
		}

		Long duration = System.currentTimeMillis() - start;
		LOG.debug("Take: " + duration + "ms");
		return "Take:" + duration + " ms <br>" + html;
	}
}
