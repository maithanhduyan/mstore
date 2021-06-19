package com.mstore.command;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mstore.domain.humanresource.entity.Employee;
import com.mstore.domain.humanresource.repository.EmployeeRepository;
import com.mstore.domain.product.entity.Product;
import com.mstore.domain.product.entity.ProductCategory;
import com.mstore.domain.product.entity.ProductSubCategory;
import com.mstore.domain.product.repository.ProductCategoryRepository;
import com.mstore.domain.product.repository.ProductRepository;
import com.mstore.domain.product.repository.ProductSubCategoryRepository;
import com.mstore.domain.sales.entity.Shop;
import com.mstore.domain.sales.repository.ShopRepository;
import com.mstore.domain.shared.entity.Currency;
import com.mstore.domain.shared.repository.CurrencyRepository;
import com.mstore.domain.shared.service.AppService;
import com.mstore.domain.shared.utils.IDUtil;
import com.mstore.domain.shared.utils.PasswordUtil;
import com.mstore.domain.system.entity.Account;
import com.mstore.domain.system.entity.AccountRole;
import com.mstore.domain.system.entity.Company;
import com.mstore.domain.system.entity.Role;
import com.mstore.domain.system.repository.AccountRepository;
import com.mstore.domain.system.repository.AccountRoleRepository;
import com.mstore.domain.system.repository.CompanyRepository;
import com.mstore.domain.system.repository.RoleRepository;

@Component
@PropertySource("classpath:shop.properties")
public class ImportDataCommandLineRunner implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(ImportDataCommandLineRunner.class);

	private static String DOMAIN_NAME = (String) AppService.context.get("domain.name");

	@Autowired
	private Environment env;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	private ProductSubCategoryRepository productSubCategoryRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	CurrencyRepository currencyRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	ShopRepository shopRepository;

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	AccountRoleRepository accountRoleRepository;

	// Shop properties
	@Value("${shop.name}")
	private String shopName;

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < args.length; i++) {
			LOG.info(args[i].toString());
			if (args[i].toString().equalsIgnoreCase("--DataSample=true")) {
				//
				insertCompanyDataSample();

				insertUserDataSample();

				insertRoleDataSample();

				insertAccountRoleDataSample();

				insertProductCategoryDataSample();

				insertProductSubCategoryDataSample();
				//
				insertProductDataSample();
				//
				insertEmployeeDataSample();
				//
				insertUserDataSample();
				//
				insertCurrencyDataSample();
				//
				insertShopDataSample();

				break;
			}

		}
	}

	int insertCompanyDataSample() {
		Company company = Company.getInstance();
		company.setId("fe932c25-e9f9-4f97-bb38-fe5a9f3bedf0");
		company.setName("MSTORE");
		company.setBrand("MSTORE");
		company.setCreatedDate(new Date());
		companyRepository.save(company);
		return 1;
	}

	int insertUserDataSample() {
		Account account = new Account();
		account.setId("43c89fd9-ebcb-481a-bd54-4e4cbdf07dd9");
		account.setUserName("admin");
		account.setEncryptPassword(PasswordUtil.encryt("password"));
		account.setCreatedDate(new Date());
		account.setActive(1);
		account.setCompany(companyRepository.getById("fe932c25-e9f9-4f97-bb38-fe5a9f3bedf0"));
		this.accountRepository.save(account);

		Account user = new Account();
		user.setId("13669c0e-bd0a-4fe4-8f2c-ae55b51154d7");
		user.setUserName("user");
		user.setActive(1);
		user.setEncryptPassword(PasswordUtil.encryt("password"));
		user.setCompany(companyRepository.getById("fe932c25-e9f9-4f97-bb38-fe5a9f3bedf0"));
		user.setCreatedDate(new Date());
		this.accountRepository.save(user);

		return 1;
	}

	int insertAccountRoleDataSample() {
		AccountRole accountRole = AccountRole.getInstance();
		accountRole.setId("99792e16-57af-4b7b-aa09-acf1fc5e76d7");
		accountRole.setAccount(accountRepository.getById("43c89fd9-ebcb-481a-bd54-4e4cbdf07dd9"));
		accountRole.setRole(roleRepository.getById("62c7598a-4c7d-4a48-92c1-b6b8d37708df"));
		accountRole.setCreatedDate(new Date());
		accountRoleRepository.save(accountRole);

		AccountRole accountRoleUser = AccountRole.getInstance();
		accountRoleUser.setId("287c254d-1ac3-4e06-be8b-f10c489187db");
		accountRoleUser.setAccount(accountRepository.getById("13669c0e-bd0a-4fe4-8f2c-ae55b51154d7"));
		accountRoleUser.setRole(roleRepository.getById("1759f863-5805-495b-9dec-34af8c21b60e"));
		accountRoleUser.setCreatedDate(new Date());
		accountRoleRepository.save(accountRoleUser);

		return 1;
	}

	int insertRoleDataSample() {

		Role admin = Role.getInstance();
		admin.setId("62c7598a-4c7d-4a48-92c1-b6b8d37708df");
		admin.setName(Role.ADMIN);
		admin.setDescription("ADMIN");
		admin.setCreatedDate(new Date());
		roleRepository.save(admin);

		Role guest = Role.getInstance();
		guest.setId("b20d6ded-5338-4745-a9b9-360ff3ff5302");
		guest.setName(Role.GUEST);
		guest.setDescription("GUEST");
		guest.setCreatedDate(new Date());
		roleRepository.save(guest);

		Role shopManager = Role.getInstance();
		shopManager.setId("4d2f1c57-e34e-4bda-8e46-f212f0e463a6");
		shopManager.setName(Role.MANAGER);
		shopManager.setDescription("MANAGER");
		shopManager.setCreatedDate(new Date());
		roleRepository.save(shopManager);

		Role cashier = Role.getInstance();
		cashier.setId("49efeef0-8099-4bf6-8d4f-248f05e695fe");
		cashier.setName(Role.CASHIER);
		cashier.setDescription("CASHIER");
		cashier.setCreatedDate(new Date());
		roleRepository.save(cashier);

		Role user = Role.getInstance();
		user.setId("1759f863-5805-495b-9dec-34af8c21b60e");
		user.setName(Role.USER);
		user.setDescription("USER");
		user.setCreatedDate(new Date());
		roleRepository.save(user);

		return 1;
	}

	int insertProductCategoryDataSample() {
		ProductCategory pCategory1 = new ProductCategory();
		pCategory1.setId("4a80657a-ad1f-4f6c-ab69-3cd7b2bb25cd");
		pCategory1.setName("TOYS");
		pCategory1.setActive(1);
		pCategory1.setCode("TOYS");
		pCategory1.setDescription("ĐỒ CHƠI");
		pCategory1.setCreatedDate(new Date());
		pCategory1.setCreatedBy("SYSTEM");
		productCategoryRepository.save(pCategory1);

		// ProductCategory 2
		ProductCategory pCategory2 = new ProductCategory();
		pCategory2.setId("60c617c7-4ca8-456d-bc02-955f71c83b66");
		pCategory2.setName("CLOTHES");
		pCategory2.setActive(1);
		pCategory2.setCode("CLOTHES");
		pCategory2.setDescription("QUẦN ÁO");
		pCategory2.setCreatedDate(new Date());
		pCategory2.setCreatedBy("SYSTEM");
		productCategoryRepository.save(pCategory2);

		// ProductCategory 3
		ProductCategory pCategory3 = new ProductCategory();
		pCategory3.setId("7cc26628-5f77-49aa-9643-58335cc4421d");
		pCategory3.setName("SHOES");
		pCategory3.setActive(1);
		pCategory3.setCode("SHOES");
		pCategory3.setDescription("GIÀY DÉP");
		pCategory3.setCreatedDate(new Date());
		pCategory3.setCreatedBy("SYSTEM");
		productCategoryRepository.save(pCategory3);

		// ProductCategory 4
		ProductCategory pCategory4 = new ProductCategory();
		pCategory4.setId("4e84e32e-12ae-412d-8fa6-8e4d666921ea");
		pCategory4.setName("WATCH");
		pCategory4.setActive(1);
		pCategory4.setCode("WATCH");
		pCategory4.setDescription("ĐỒNG HỒ");
		pCategory4.setCreatedDate(new Date());
		pCategory4.setCreatedBy("SYSTEM");
		productCategoryRepository.save(pCategory4);

		// ProductCategory 5
		ProductCategory pCategory5 = new ProductCategory();
		pCategory5.setId("475a58c4-f635-4252-bba5-c6d2a293b9d9");
		pCategory5.setName("COSMETICS ");
		pCategory5.setActive(1);
		pCategory5.setCode("COSMETICS");
		pCategory5.setDescription("MỸ PHẨM");
		pCategory5.setCreatedDate(new Date());
		pCategory5.setCreatedBy("SYSTEM");
		productCategoryRepository.save(pCategory5);

		// ProductCategory 6
		ProductCategory pCategory6 = new ProductCategory();
		pCategory6.setId("14d19919-6e64-4001-939f-b35c322ec59d");
		pCategory6.setName("JEWELRY ");
		pCategory6.setActive(1);
		pCategory6.setCode("JEWELRY");
		pCategory6.setDescription("TRANG SỨC");
		pCategory6.setCreatedDate(new Date());
		pCategory6.setCreatedBy("SYSTEM");
		productCategoryRepository.save(pCategory6);

		// ProductCategory 7
		ProductCategory pCategory7 = new ProductCategory();
		pCategory7.setId("f198367-c1dc-40a8-8bf2-431cec608ea2");
		pCategory7.setName("PERFUME ");
		pCategory7.setActive(1);
		pCategory7.setCode("PERFUME");
		pCategory7.setDescription("NƯỚC HOA");
		pCategory7.setCreatedDate(new Date());
		pCategory7.setCreatedBy("SYSTEM");
		productCategoryRepository.save(pCategory7);

		return 1;
	}

	int insertProductSubCategoryDataSample() {
		// ProductSubCategory 1
		ProductSubCategory productSubCategory1 = new ProductSubCategory();
		productSubCategory1.setId("63b87ec1-31c0-468c-aed7-d09dadc6630a");
		productSubCategory1
				.setCategory(productCategoryRepository.findById("4a80657a-ad1f-4f6c-ab69-3cd7b2bb25cd").orElse(null));
		productSubCategory1.setName("PUZZLE");
		productSubCategory1.setCode("PUZZLE");
		productSubCategory1.setDescription("TRÍ TUỆ");
		productSubCategory1.setImageURL("/assets/product/category/puzzle.png");
		productSubCategory1.setActive(1);
		productSubCategory1.setCreatedBy("SYSTEM");
		productSubCategory1.setCreatedDate(new Date());
		this.productSubCategoryRepository.save(productSubCategory1);

		// ProductSubCategory 2
		ProductSubCategory productSubCategory2 = new ProductSubCategory();
		productSubCategory2.setId("0c413052-6cb7-41cb-9fe6-41506bee173c");
		productSubCategory2
				.setCategory(productCategoryRepository.findById("60c617c7-4ca8-456d-bc02-955f71c83b66").orElse(null));
		productSubCategory2.setName("MEN");
		productSubCategory2.setCode("MEN");
		productSubCategory2.setDescription("NAM");
		productSubCategory2.setImageURL("/assets/product/category/clothes.png");
		productSubCategory2.setActive(1);
		productSubCategory2.setCreatedBy("SYSTEM");
		productSubCategory2.setCreatedDate(new Date());
		this.productSubCategoryRepository.save(productSubCategory2);

		// ProductSubCategory 3
		ProductSubCategory productSubCategory3 = new ProductSubCategory();
		productSubCategory3.setId("23d4e981-a5a2-472e-950a-148c6276f8c6");
		productSubCategory3
				.setCategory(productCategoryRepository.findById("60c617c7-4ca8-456d-bc02-955f71c83b66").orElse(null));
		productSubCategory3.setName("WOMEN");
		productSubCategory3.setCode("WOMEN");
		productSubCategory3.setDescription("NỮ");
		productSubCategory3.setImageURL("/assets/product/category/clothes_women.png");
		productSubCategory3.setActive(1);
		productSubCategory3.setCreatedBy("SYSTEM");
		productSubCategory3.setCreatedDate(new Date());
		this.productSubCategoryRepository.save(productSubCategory3);

		// ProductSubCategory 4
		ProductSubCategory womenShoes = new ProductSubCategory();
		womenShoes.setId("d9c23515-512c-49fb-b280-9abbaebe7b57");
		womenShoes.setCategory(productCategoryRepository.findById("7cc26628-5f77-49aa-9643-58335cc4421d").orElse(null));
		womenShoes.setName("WOMEN");
		womenShoes.setCode("WOMEN");
		womenShoes.setDescription("NỮ");
		womenShoes.setImageURL("/assets/product/category/shoes_women.png");
		womenShoes.setActive(1);
		womenShoes.setCreatedBy("SYSTEM");
		womenShoes.setCreatedDate(new Date());
		this.productSubCategoryRepository.save(womenShoes);

		// ProductSubCategory 4
		ProductSubCategory menShoes = new ProductSubCategory();
		menShoes.setId("5a6e2cb8-0c48-4ee6-9b62-e8a10af6be7e");
		menShoes.setCategory(productCategoryRepository.findById("7cc26628-5f77-49aa-9643-58335cc4421d").orElse(null));
		menShoes.setName("MEN");
		menShoes.setCode("MEN");
		menShoes.setDescription("NAM");
		menShoes.setImageURL("/assets/product/category/shoes_men.png");
		menShoes.setActive(1);
		menShoes.setCreatedBy("SYSTEM");
		menShoes.setCreatedDate(new Date());
		this.productSubCategoryRepository.save(menShoes);

		// ProductSubCategory 5
		ProductSubCategory menWatch = new ProductSubCategory();
		menWatch.setId("59595a8b-8d9e-4c34-a2d9-83b6bdf55352");
		menWatch.setCategory(productCategoryRepository.findById("4e84e32e-12ae-412d-8fa6-8e4d666921ea").orElse(null));
		menWatch.setName("MEN");
		menWatch.setCode("MEN");
		menWatch.setDescription("NAM");
		menWatch.setImageURL("/assets/product/category/watch_men.png");
		menWatch.setActive(1);
		menWatch.setCreatedBy("SYSTEM");
		menWatch.setCreatedDate(new Date());
		this.productSubCategoryRepository.save(menWatch);

		// ProductSubCategory 6
		ProductSubCategory womenWatch = new ProductSubCategory();
		womenWatch.setId("e1f026a5-fd5f-4464-bb19-f4353b3f1ec0");
		womenWatch.setCategory(productCategoryRepository.findById("4e84e32e-12ae-412d-8fa6-8e4d666921ea").orElse(null));
		womenWatch.setName("WOMEN");
		womenWatch.setCode("WOMEN");
		womenWatch.setDescription("NỮ");
		womenWatch.setImageURL("/assets/product/category/watch_women.png");
		womenWatch.setActive(1);
		womenWatch.setCreatedBy("SYSTEM");
		womenWatch.setCreatedDate(new Date());
		this.productSubCategoryRepository.save(womenWatch);

		// ProductSubCategory 7
		ProductSubCategory smartWatch = new ProductSubCategory();
		smartWatch.setId("3314f336-b377-40b7-8b36-e75ef70fd99f");
		smartWatch.setCategory(productCategoryRepository.findById("4e84e32e-12ae-412d-8fa6-8e4d666921ea").orElse(null));
		smartWatch.setName("SMART WATCH");
		smartWatch.setCode("SMART WATCH");
		smartWatch.setDescription("SMART WATCH");
		smartWatch.setImageURL("/assets/product/category/smart_watch.png");
		smartWatch.setActive(1);
		smartWatch.setCreatedBy("SYSTEM");
		smartWatch.setCreatedDate(new Date());
		this.productSubCategoryRepository.save(smartWatch);

		return 1;
	}

	// Insert Product Function
	int insertProductDataSample() {
		String[] badges = { "<div class=\"sale-off-badge\">Sale <span>-36%</span></div>",
				"<div class=\"new-badge \">New</div>" };
		String[] images = { "/assets/product/Battle_Cast_Slider_Level3.jpg" //
				, "/assets/product/Battle_Cast_Star_DifficultyLevel3.jpg" //
				, "/assets/product/Removing_Cast_Loop_Level1.jpg" //
				, "/assets/product/Removing_Cast_Snow_Level2.jpg" //
				, "/assets/product/Removing_Cast_Box_Level2.jpg" //
				, "/assets/product/Removing_Cast_Cage_Level3.jpg" //
				, "/assets/product/Removing_Cast_Dot_Level2.jpg" //
				, "/assets/product/Removing_Cast_Harmony_Difficulty_Level2.jpg" //
				, "/assets/product/Removing_Cast_Hook_Level2.jpg" //
				, "/assets/product/Shaku_Cast_Key_II_Difficulty_Level2.jpg" //
				, "/assets/product/Tobu_Cast_S_Difficulty_Level3.jpg" //
				, "/assets/product/Toppo_Cast_ABC_Level1.jpg" //
		};
		String[] productNames = { "Battle Cast Slider Level 3" //
				, "Battle Cast Star Difficulty Level 3" //
				, "Removing Cast Loop [Level 1]" //
				, "Removing Cast Snow [Level 2]" //
				, "Removing Cast Box Level 2" //
				, "Removing Cast Cage Level 3" //
				, "Removing Cast Dot Level 2" //
				, "Removing Cast Harmony Difficulty Level 2 " //
				, "Removing Cast Hook Level 2 " //
				, "Shaku Cast Key II Difficulty Level 2 " //
				, "Tobu Cast S Difficulty Level 3 " //
				, "Toppo Cast ABC Level 1 " //
		};
		Long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			Product p = new Product();
			p.setId(UUID.randomUUID().toString());
			int nameIndex = new Random().nextInt(productNames.length);
			p.setName(productNames[nameIndex]);
			int code = new Random().nextInt(200000);
			p.setCode("CODE-" + code);
			p.setBadge(badges[new Random().nextInt(2)]);
			int costPrice = new Random().nextInt(200000);
			p.setCostPrice(costPrice);
			p.setImageURL(images[nameIndex]);
			p.setLinkURL("https://localhost:8080/assets/product/" + images[nameIndex]);
			p.setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!");
			int salePrice = costPrice + (costPrice * 30 / 100);
			p.setSalePrice(salePrice);
			p.setPromoPrice(salePrice - (salePrice * new Random().nextInt(20) / 100));
			p.setActive(1);
			p.setInStock(5);
			p.setCreatedBy("SYSTEM");
			p.setCreatedDate(new Date());
			p.setSubCategory(
					productSubCategoryRepository.findById("63b87ec1-31c0-468c-aed7-d09dadc6630a").orElse(null));
			this.productRepository.save(p);
		}

		// Clothes 1
		Product clothes1 = new Product();
		clothes1.setId("8a756d72-b2da-4663-bf21-78e370473dec");

		clothes1.setName("T-Shirt Men Oxfort Blue - Tay Ngắn");
		int code = new Random().nextInt(200000);
		clothes1.setCode("CODE-" + code);
		clothes1.setBadge(badges[new Random().nextInt(2)]);
		int costPrice = new Random().nextInt(200000);
		clothes1.setCostPrice(costPrice);
		clothes1.setImageURL("/assets/product/t_shirt_men_Oxfort_blue_1.jpg");
		clothes1.setLinkURL("http://localhost:8080/assets/product/8a756d72-b2da-4663-bf21-78e370473dec");
		clothes1.setDescription("Áo sơ mi Nam - Tay Ngắn - Xanh Dương");
		int salePrice = costPrice + (costPrice * 30 / 100);
		clothes1.setSalePrice(salePrice);
		clothes1.setPromoPrice(salePrice - (salePrice * new Random().nextInt(20) / 100));
		clothes1.setActive(1);
		clothes1.setInStock(5);
		clothes1.setCreatedBy("SYSTEM");
		clothes1.setCreatedDate(new Date());
		clothes1.setSubCategory(
				productSubCategoryRepository.findById("0c413052-6cb7-41cb-9fe6-41506bee173c").orElse(null));
		this.productRepository.save(clothes1);

		// Clothes 2
		Product clothes2 = new Product();
		clothes2.setId("fd6046b5-ef5b-4b5f-a8f8-984951b0d8d2");
		clothes2.setName(" Men's Long Sleeve Short Sleeve Casual Solid Oxford Shirt Men's Casual Cotton Shirt");
		clothes2.setCode("CODE-" + new Random().nextInt(200000));
		clothes2.setBadge(badges[new Random().nextInt(2)]);
		int costPrice2 = new Random().nextInt(200000);
		clothes2.setCostPrice(costPrice2);
		clothes2.setImageURL(
				"/assets/product/Men's_Long_Sleeve_Short_Sleeve_Casual_Solid_Oxford_Shirt_Men's_Casual_Cotton_Shirt.jpg");
		clothes2.setLinkURL("http://localhost:8080/assets/product/8a756d72-b2da-4663-bf21-78e370473dec");
		clothes2.setDescription("Áo sơ mi Nam - Tay Ngắn - Xanh Dương");
		int salePrice2 = costPrice2 + (costPrice2 * 30 / 100);
		clothes2.setSalePrice(salePrice2);
		clothes2.setPromoPrice(salePrice2 - (salePrice2 * new Random().nextInt(20) / 100));
		clothes2.setActive(1);
		clothes2.setInStock(5);
		clothes2.setCreatedBy("SYSTEM");
		clothes2.setCreatedDate(new Date());
		clothes2.setSubCategory(
				productSubCategoryRepository.findById("0c413052-6cb7-41cb-9fe6-41506bee173c").orElse(null));
		this.productRepository.save(clothes2);

		// Clothes 3
		Product clothes3 = new Product();
		clothes3.setId("9b7c73ab-a712-471a-b9b0-3b89ad57e8f0");
		clothes3.setName("Natural Beauty Basic Scallop Lace Tight Skirt");
		clothes3.setCode("CODE-" + new Random().nextInt(200000));
		clothes3.setBadge(badges[new Random().nextInt(2)]);
		int costPrice3 = new Random().nextInt(200000);
		clothes3.setCostPrice(costPrice3);
		clothes3.setSku("VAY-01");
		clothes3.setImageURL("/assets/product/Natural_Beauty_Basic_Scallop_Lace_Tight_Skirt.jpg");
		clothes3.setLinkURL("http://localhost:8080/assets/product/9b7c73ab-a712-471a-b9b0-3b89ad57e8f0");
		clothes3.setDescription("Váy Nữ - Công Sở - VÀNG KEM ");
		int salePrice3 = costPrice3 + (costPrice3 * 30 / 100);
		clothes3.setSalePrice(salePrice3);
		clothes3.setPromoPrice(salePrice3 - (salePrice3 * new Random().nextInt(20) / 100));
		clothes3.setActive(1);
		clothes3.setInStock(5);
		clothes3.setCreatedBy("SYSTEM");
		clothes3.setCreatedDate(new Date());
		clothes3.setSubCategory(
				productSubCategoryRepository.findById("23d4e981-a5a2-472e-950a-148c6276f8c6").orElse(null));
		this.productRepository.save(clothes3);

		// Clothes 4
		Product clothes4 = new Product();
		clothes4.setId("924ac2c4-d555-4e46-a5d6-663721391b85");
		clothes4.setName("Natural Beauty Basic Embroidery Blouse");
		clothes4.setCode("CODE-" + new Random().nextInt(200000));
		clothes4.setBadge(badges[new Random().nextInt(2)]);
		int costPrice4 = new Random().nextInt(200000);
		clothes4.setCostPrice(costPrice4);
		clothes4.setSku("AONU-01");
		clothes4.setImageURL("/assets/product/Natural_Beauty_Basic_Embroidery_Blouse.jpg");
		clothes4.setLinkURL("http://localhost:8080/assets/product/924ac2c4-d555-4e46-a5d6-663721391b85");
		clothes4.setDescription("ÁO SƠ MI Nữ - MÙA HÈ - VÀNG KEM ");
		int salePrice4 = costPrice4 + (costPrice4 * 30 / 100);
		clothes4.setSalePrice(salePrice4);
		clothes4.setPromoPrice(salePrice4 - (salePrice4 * new Random().nextInt(20) / 100));
		clothes4.setActive(1);
		clothes4.setInStock(5);
		clothes4.setCreatedBy("SYSTEM");
		clothes4.setCreatedDate(new Date());
		clothes4.setSubCategory(
				productSubCategoryRepository.findById("23d4e981-a5a2-472e-950a-148c6276f8c6").orElse(null));
		this.productRepository.save(clothes4);

		// Shoes 1
		Product shoes1 = new Product();
		shoes1.setId("e9254332-4ac6-4638-9624-6234d8aa72ab");
		shoes1.setName("SAGUARO Barefoot Running Shoes, Portable, Fitness Shoes, Ultra Lightweight, Breathable");
		shoes1.setCode("CODE-" + new Random().nextInt(200000));
		shoes1.setBadge(badges[new Random().nextInt(2)]);
		int costShoes1 = new Random().nextInt(200000);
		shoes1.setCostPrice(costShoes1);
		shoes1.setSku("GIAY-01");
		shoes1.setImageURL("/assets/product/"
				+ "SAGUARO_Barefoot_Running_Shoes_Portable_Fitness_Shoes_Flexible_Ultra_Lightweight_Breathable.jpg");
		shoes1.setLinkURL("http://localhost:8080/assets/product/" + shoes1.getId());
		shoes1.setDescription("GIÀY THỂ THAO NỮ - SIÊU NHẸ, NĂNG ĐỘNG ");
		int saleShoes1 = costShoes1 + (costShoes1 * 30 / 100);
		shoes1.setSalePrice(saleShoes1);
		shoes1.setPromoPrice(saleShoes1 - (saleShoes1 * new Random().nextInt(20) / 100));
		shoes1.setActive(1);
		shoes1.setInStock(5);
		shoes1.setCreatedBy("SYSTEM");
		shoes1.setCreatedDate(new Date());
		shoes1.setSubCategory(
				productSubCategoryRepository.findById("d9c23515-512c-49fb-b280-9abbaebe7b57").orElse(null));
		this.productRepository.save(shoes1);

		// Shoes 2
		Product shoes2 = new Product();
		shoes2.setId("534cf7ac-97f0-49fd-8eac-a5ca3d282631");
		shoes2.setName("WEIDANSIER 2018 Running Shoes, Men's Winter");
		shoes2.setCode("CODE-" + new Random().nextInt(200000));
		shoes2.setBadge(badges[new Random().nextInt(2)]);
		int costShoes2 = new Random().nextInt(2000000);
		shoes2.setCostPrice(costShoes2);
		shoes2.setSku("GIAY-02");
		shoes2.setImageURL(
				"/assets/product/WEIDANSIER_2018_Running_Shoes_Mens_Shoes_Sneakers_Shoes_Colorful_Air_Lightweight.jpg");
		shoes2.setLinkURL("http://localhost:8080/assets/product/" + shoes2.getId());
		shoes2.setDescription("GIÀY THỂ THAO NAM - SIÊU NHẸ, NĂNG ĐỘNG ");
		int saleShoes2 = costShoes2 + (costShoes2 * 30 / 100);
		shoes2.setSalePrice(saleShoes2);
		shoes2.setPromoPrice(saleShoes2 - (saleShoes2 * new Random().nextInt(20) / 100));
		shoes2.setActive(1);
		shoes2.setInStock(5);
		shoes2.setCreatedBy("SYSTEM");
		shoes2.setCreatedDate(new Date());
		shoes2.setSubCategory(
				productSubCategoryRepository.findById("5a6e2cb8-0c48-4ee6-9b62-e8a10af6be7e").orElse(null));
		this.productRepository.save(shoes2);

		// Watch 1
		Product smartWatch1 = new Product();
		smartWatch1.setId("b25c6195-99c4-48ff-bbde-3560ff3ad322");
		smartWatch1.setName("KYOKA 2021 Bluetooth 5.0 smart watch");
		smartWatch1.setCode("CODE-" + new Random().nextInt(20000));
		smartWatch1.setBadge(badges[new Random().nextInt(2)]);
		int costsmartWatch1 = new Random().nextInt(20000000);
		smartWatch1.setCostPrice(costsmartWatch1);
		smartWatch1.setSku("SMWAT-01");
		smartWatch1.setImageURL("/assets/product/" + "KYOKA_2021_Bluetooth5.0_smart_watch.jpg");
		smartWatch1.setLinkURL("http://localhost:8080/assets/product/" + smartWatch1.getId());
		smartWatch1.setDescription(
				"Đồng hồ thông minh KYOKA 2021 đồng hồ thông minh Bluetooth5.0 mới nhất đồng hồ hoạt động đồng hồ đo bước đi đồng hồ thể thao IP67 chống nước 24 chế độ thể thao GPS ghi âm");
		int salesmartWatch1 = costsmartWatch1 + (costsmartWatch1 * 30 / 100);
		smartWatch1.setSalePrice(salesmartWatch1);
		smartWatch1.setPromoPrice(salesmartWatch1 - (salesmartWatch1 * new Random().nextInt(20) / 100));
		smartWatch1.setActive(1);
		smartWatch1.setInStock(5);
		smartWatch1.setCreatedBy("SYSTEM");
		smartWatch1.setCreatedDate(new Date());
		smartWatch1.setSubCategory(
				productSubCategoryRepository.findById("3314f336-b377-40b7-8b36-e75ef70fd99f").orElse(null));
		this.productRepository.save(smartWatch1);

		// Watch 2
		Product menWatch1 = new Product();
		menWatch1.setId("44e3d126-97a6-46dd-913c-536dbeafc60b");
		menWatch1.setName("Tissot T1204071705100 Men's Wristwatch 1000 Automatic Silver");
		menWatch1.setCode("CODE-" + new Random().nextInt(20000));
		menWatch1.setBadge(badges[new Random().nextInt(2)]);
		int costmenWatch1 = 16000000;
		menWatch1.setCostPrice(costmenWatch1);
		menWatch1.setSku("MWAT-01");
		menWatch1.setImageURL("/assets/product/" + "Tissot_T1204071705100_Men's_Wristwatch_1000_Automatic_Silver.jpg");
		menWatch1.setLinkURL("http://localhost:8080/assets/product/" + menWatch1.getId());
		menWatch1.setDescription("Đồng hồ đeo tay nam Tissot T1204071705100 1000 Automatic Silver");
		int salemenWatch1 = costmenWatch1 + (costmenWatch1 * 30 / 100);
		menWatch1.setSalePrice(salemenWatch1);
		menWatch1.setPromoPrice(salemenWatch1 - (salemenWatch1 * new Random().nextInt(20) / 100));
		menWatch1.setActive(1);
		menWatch1.setInStock(5);
		menWatch1.setCreatedBy("SYSTEM");
		menWatch1.setCreatedDate(new Date());
		menWatch1.setSubCategory(
				productSubCategoryRepository.findById("59595a8b-8d9e-4c34-a2d9-83b6bdf55352").orElse(null));
		this.productRepository.save(menWatch1);

		// Watch 3
		Product womenWatch1 = new Product();
		womenWatch1.setId("e479642f-3b8a-4fb5-befe-ea25254b530d");
		womenWatch1.setName("Hannah Martin Women's Quartz Wristwatch, Bangle Bracelet Watch for Women");
		womenWatch1.setCode("CODE-" + new Random().nextInt(20000));
		womenWatch1.setBadge(badges[new Random().nextInt(2)]);
		int costwomenWatch1 = 5200000;
		womenWatch1.setCostPrice(costwomenWatch1);
		womenWatch1.setSku("WMWAT-01");
		womenWatch1.setImageURL("/assets/product/"
				+ "Hannah_Martin_Womens_Quartz_Wristwatch_Stylish_Classic_Simple_For_Business_Made_in_Japan_Bangle_Bracelet_Watch_for_Women.jpg");
		womenWatch1.setLinkURL("http://localhost:8080/assets/product/" + womenWatch1.getId());
		womenWatch1.setDescription(
				"Đồng hồ đeo tay thạch anh cho nữ Hannah Martin, Kiểu dáng, Cổ điển, Đơn giản, Dành cho Doanh nhân, Sản xuất tại Nhật Bản, Đồng hồ đeo tay cho nữ");
		int salewomenWatch1 = costwomenWatch1 + (costwomenWatch1 * 30 / 100);
		womenWatch1.setSalePrice(salewomenWatch1);
		womenWatch1.setPromoPrice(salewomenWatch1 - (salewomenWatch1 * new Random().nextInt(20) / 100));
		womenWatch1.setActive(1);
		womenWatch1.setInStock(5);
		womenWatch1.setCreatedBy("SYSTEM");
		womenWatch1.setCreatedDate(new Date());
		womenWatch1.setSubCategory(
				productSubCategoryRepository.findById("e1f026a5-fd5f-4464-bb19-f4353b3f1ec0").orElse(null));
		this.productRepository.save(womenWatch1);

		Long duration = System.currentTimeMillis() - start;
		LOG.debug("Insert Sample Product Data." + " (" + duration + "ms)");
		return 1;
	}

	int insertEmployeeDataSample() {
		// Employee
		Long start = System.currentTimeMillis();
		String[] lastName = { "Lê", "Nguyễn", "Mai", "Võ", "Trần", "Phan", "Trịnh" };
		String[] sampleNames = { "Nam", "An", "Tài", "Võ", "Đức", "Tiến", "Minh", "Trí", "Thiện", "Tâm" };
		for (int i = 0; i < 10; i++) {
			Employee employee = new Employee();
			String name = sampleNames[new Random().nextInt(10)];
			employee.setName(name);
			employee.setFullName(lastName[new Random().nextInt(7)].toString() + " " + name);
			employee.setHireDate(new Date());
			employee.setId(UUID.randomUUID().toString());
			employee.setCreatedDate(new Date());
			this.employeeRepository.save(employee);
		}
		Long duration = System.currentTimeMillis() - start;
		LOG.debug("Insert Sample Data." + " (" + duration + "ms)");
		return 1;
	}

	int insertShopDataSample() {
		Shop shop = new Shop();
		shop.setId("11623e31-d926-4bca-b5d5-ea5661994aa5");
		shop.setName(shopName);
		this.shopRepository.save(shop);
		return 1;
	}

	int insertCurrencyDataSample() {
		Long start = System.currentTimeMillis();
		Currency[] currencies = { new Currency("1", "USD", "US Dollar", "$", new Date(), null),
				new Currency("2", "JPY", "Yen", "¥", new Date(), null),
				new Currency("3", "EUR", "Euro", "€", new Date(), null),
				new Currency("4", "GBP", "Pound Sterling", "£", new Date(), null),
				new Currency("5", "VND", "Dong", "₫", new Date(), null),
				new Currency("6", "AFN", "Afghani", "؋", new Date(), null),
				new Currency("7", "ALL", "Lek", "Lek", new Date(), null),
				new Currency("8", "ANG", "Netherlands Antillian Guilder", "ƒ", new Date(), null),
				new Currency("9", "ARS", "Argentine Peso", "$", new Date(), null),
				new Currency("10", "AUD", "Australian Dollar", "$", new Date(), null),
				new Currency("11", "AWG", "Aruban Guilder", "ƒ", new Date(), null),
				new Currency("12", "AZN", "Azerbaijanian Manat", "ман", new Date(), null),
				new Currency("13", "BAM", "Convertible Marks", "KM", new Date(), null),
				new Currency("14", "BBD", "Barbados Dollar", "KM", new Date(), null),
				new Currency("15", "BGN", "Bulgarian Lev", "лв", new Date(), null),
				new Currency("16", "BMD", "Bermudian Dollar", "$", new Date(), null),
				new Currency("17", "BND", "Brunei Dollar", "$", new Date(), null),
				new Currency("18", "BOB", "BOV Boliviano Mvdol", "$b", new Date(), null),
				new Currency("19", "BRL", "Brazilian Real", "R$", new Date(), null),
				new Currency("20", "BSD", "Bahamian Dollar", "$", new Date(), null),
				new Currency("21", "BWP", "Pula", "P", new Date(), null),
				new Currency("22", "BYR", "Belarussian Ruble", "p.", new Date(), null),
				new Currency("23", "BZD", "Belize Dollar", "BZ$", new Date(), null),
				new Currency("24", "CAD", "Canadian Dollar", "$", new Date(), null),
				new Currency("25", "CHF", "Swiss Franc", "CHF", new Date(), null),
				new Currency("26", "CLP", "CLF Chilean Peso Unidades de fomento", "$", new Date(), null),
				new Currency("27", "CNY", "Yuan Renminbi", "¥", new Date(), null),
				new Currency("28", "COP", "COU Colombian Peso Unidad de Valor Real", "$", new Date(), null),
				new Currency("29", "CRC", "Costa Rican Colon", "₡", new Date(), null),
				new Currency("30", "CUP", "CUC Cuban Peso Peso Convertible", "₱", new Date(), null),
				new Currency("31", "CZK", "Czech Koruna", "Kč", new Date(), null),
				new Currency("32", "DKK", "Danish Krone", "kr", new Date(), null),
				new Currency("33", "DOP", "Dominican Peso", "RD$", new Date(), null),
				new Currency("34", "EGP", "Egyptian Pound", "£", new Date(), null),
				new Currency("35", "FJD", "Fiji Dollar", "$", new Date(), null),
				new Currency("36", "FKP", "Falkland Islands Pound", "£", new Date(), null),
				new Currency("37", "GIP", "Gibraltar Pound", "£", new Date(), null),
				new Currency("38", "GTQ", "Quetzal", "Q", new Date(), null),
				new Currency("39", "GYD", "Guyana Dollar", "$", new Date(), null),
				new Currency("40", "HKD", "Hong Kong Dollar", "$", new Date(), null),
				new Currency("41", "HNL", "Lempira", "L", new Date(), null),
				new Currency("42", "HRK", "Croatian Kuna", "kn", new Date(), null),
				new Currency("43", "HUF", "Forint", "Ft", new Date(), null),
				new Currency("44", "IDR", "Rupiah", "Rp", new Date(), null),
				new Currency("45", "ILS", "New Israeli Sheqel", "₪", new Date(), null),
				new Currency("46", "IRR", "Iranian Rial", "﷼", new Date(), null),
				new Currency("47", "ISK", "Iceland Krona", "kr", new Date(), null),
				new Currency("48", "JMD", "Jamaican Dollar", "J$", new Date(), null),
				new Currency("49", "KGS", "Som", "лв", new Date(), null),
				new Currency("50", "KHR", "Riel", "៛", new Date(), null),
				new Currency("51", "KPW", "North Korean Won", "₩", new Date(), null),
				new Currency("52", "KRW", "Won", "₩", new Date(), null),
				new Currency("53", "KYD", "Cayman Islands Dollar", "$", new Date(), null),
				new Currency("54", "KZT", "Tenge", "лв", new Date(), null),
				new Currency("55", "LAK", "Kip", "₭", new Date(), null),
				new Currency("56", "LBP", "Lebanese Pound", "£", new Date(), null),
				new Currency("57", "LKR", "Sri Lanka Rupee", "₨", new Date(), null),
				new Currency("58", "LRD", "Liberian Dollar", "$", new Date(), null),
				new Currency("59", "LTL", "Lithuanian Litas", "Lt", new Date(), null),
				new Currency("60", "LVL", "Latvian Lats", "Ls", new Date(), null),
				new Currency("61", "MKD", "Denar", "ден", new Date(), null),
				new Currency("62", "MNT", "Tugrik", "₮", new Date(), null),
				new Currency("63", "MUR", "Mauritius Rupee", "₨", new Date(), null),
				new Currency("64", "MXN", "MXV Mexican Peso Mexican Unidad de Inversion (UDI)", "$", new Date(), null),
				new Currency("65", "MYR", "Malaysian Ringgit", "RM", new Date(), null),
				new Currency("66", "MZN", "Metical", "MT", new Date(), null),
				new Currency("67", "NGN", "Naira", "₦", new Date(), null),
				new Currency("68", "NIO", "Cordoba Oro", "C$", new Date(), null),
				new Currency("69", "NOK", "Norwegian Krone", "kr", new Date(), null),
				new Currency("70", "NPR", "Nepalese Rupee", "₨", new Date(), null),
				new Currency("71", "NZD", "New Zealand Dollar", "$", new Date(), null),
				new Currency("72", "OMR", "Rial Omani", "﷼", new Date(), null),
				new Currency("73", "PAB", "USD Balboa US Dollar", "B\\/.", new Date(), null),
				new Currency("74", "PEN", "Nuevo Sol", "S\\/.", new Date(), null),
				new Currency("75", "PHP", "Philippine Peso", "Php", new Date(), null),
				new Currency("76", "PKR", "Pakistan Rupee", "₨", new Date(), null),
				new Currency("77", "PLN", "Zloty", "zł", new Date(), null),
				new Currency("78", "PYG", "Guarani", "Gs", new Date(), null),
				new Currency("79", "QAR", "Qatari Rial", "﷼", new Date(), null),
				new Currency("80", "RON", "New Leu", "lei", new Date(), null),
				new Currency("81", "RSD", "Serbian Dinar", "Дин.", new Date(), null),
				new Currency("82", "RUB", "Russian Ruble", "руб", new Date(), null),
				new Currency("83", "SAR", "Saudi Riyal", "﷼", new Date(), null),
				new Currency("84", "SBD", "Solomon Islands Dollar", "$", new Date(), null),
				new Currency("85", "SCR", "Seychelles Rupee", "₨", new Date(), null),
				new Currency("86", "SEK", "Swedish Krona", "kr", new Date(), null),
				new Currency("87", "SGD", "Singapore Dollar", "$", new Date(), null),
				new Currency("88", "SHP", "Saint Helena Pound", "£", new Date(), null),
				new Currency("89", "SOS", "Somali Shilling", "S", new Date(), null),
				new Currency("90", "SRD", "Surinam Dollar", "$", new Date(), null),
				new Currency("91", "SVC", "USD El Salvador Colon US Dollar", "$", new Date(), null),
				new Currency("92", "SYP", "Syrian Pound", "£", new Date(), null),
				new Currency("93", "THB", "Baht", "฿", new Date(), null),
				new Currency("94", "TRY", "Turkish Lira", "TL", new Date(), null),
				new Currency("95", "TTD", "Trinidad and Tobago Dollar", "TT$", new Date(), null),
				new Currency("96", "TWD", "New Taiwan Dollar", "NT$", new Date(), null),
				new Currency("97", "UAH", "Hryvnia", "₴", new Date(), null),
				new Currency("98", "UYU", "UYI Peso Uruguayo Uruguay Peso en Unidades Indexadas", "$U", new Date(),
						null),
				new Currency("99", "UZS", "Uzbekistan Sum", "лв", new Date(), null),
				new Currency("100", "VEF", "Bolivar Fuerte", "Bs", new Date(), null),
				new Currency("101", "XCD", "East Caribbean Dollar", "$", new Date(), null),
				new Currency("102", "YER", "Yemeni Rial", "﷼", new Date(), null),
				new Currency("103", "ZAR", "Rand", "R", new Date(), null)

		};

		for (int i = 0; i < currencies.length; i++) {
			this.currencyRepository.save(currencies[i]);
		}

		Long duration = System.currentTimeMillis() - start;
		LOG.debug("Insert Sample Data." + " (" + duration + "ms)");
		return 1;
	}
}
