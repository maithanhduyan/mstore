package com.mstore.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mstore.entities.Employee;
import com.mstore.entities.Product;
import com.mstore.repositories.EmployeeRepository;
import com.mstore.repositories.ProductRepository;

@Controller
public class MainController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProductRepository productRepository;

	private static final String[] NAMES = new String[] { "Tom", "Jerry", "Donald" };

	@ResponseBody
	@RequestMapping("/")
	public String home() {
		String html = "";
		html += "<ul>";
		html += " <li><a href='/testInsert'>Test Insert</a></li>";
		html += " <li><a href='/showAllEmployee'>Show All Employee</a></li>";
		html += " <li><a href='/showFullNameLikeTom'>Show All 'Tom'</a></li>";
		html += " <li><a href='/deleteAllEmployee'>Delete All Employee</a></li>";
		html += " <li><a href='/addProduct'>Add Product</a></li>";
		html += " <li><a href='/showAllProduct'>Show All Product</a></li>";
		html += "</ul>";
		return html;
	}

	@ResponseBody
	@RequestMapping("/testInsert")
	public String testInsert() {

		Long empIdMax = this.employeeRepository.getMaxId();

		Employee employee = new Employee();

		int random = new Random().nextInt(3);

		long id = empIdMax + 1;
		String fullName = NAMES[random] + " " + id;

		employee.setId(id);
		employee.setEmpNo("E" + id);
		employee.setFullName(fullName);
		employee.setHireDate(new Date());
		this.employeeRepository.save(employee);

		return "Inserted: " + employee;
	}

	@ResponseBody
	@RequestMapping("/showAllEmployee")
	public String showAllEmployee() {

		Iterable<Employee> employees = this.employeeRepository.findAll();

		String html = "";
		for (Employee emp : employees) {
			html += emp + "<br>";
		}

		return html;
	}

	@ResponseBody
	@RequestMapping("/showFullNameLikeTom")
	public String showFullNameLikeTom() {

		List<Employee> employees = this.employeeRepository.findByFullNameLike("Tom");

		String html = "";
		for (Employee emp : employees) {
			html += emp + "<br>";
		}

		return html;
	}

	@ResponseBody
	@RequestMapping("/deleteAllEmployee")
	public String deleteAllEmployee() {

		this.employeeRepository.deleteAll();
		return "Deleted!";
	}

	@ResponseBody
	@RequestMapping("/addProduct")
	public String addProduct() {

		String id = UUID.randomUUID().toString();

		Product product = new Product();
		product.setId(id);
		int code = new Random().nextInt(200000);
		product.setCode("C" + code);
		this.productRepository.save(product);

		return "Inserted: " + product;
	}

	@ResponseBody
	@RequestMapping("/showAllProduct")
	public String showAllProduct() {

		Iterable<Product> product = this.productRepository.findAll();

		String html = "";
		for (Product p : product) {
			html += p + "<br>";
		}

		return html;
	}
}
