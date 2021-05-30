/**
 * @author Mai Thành Duy An
 */
package com.mstore.command;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mstore.entities.Currency;
import com.mstore.entities.Employee;
import com.mstore.entities.Product;
import com.mstore.entities.User;
import com.mstore.repositories.CurrencyRepository;
import com.mstore.repositories.ProductRepository;
import com.mstore.repositories.humanresource.EmployeeRepository;
import com.mstore.repositories.humanresource.UserRepository;

@Component
public class ImportDataCommandLineRunner implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(ImportDataCommandLineRunner.class);

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	CurrencyRepository currencyRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < args.length; i++) {
			log.info(args[i].toString());
			if (args[i].toString().equalsIgnoreCase("--DataSample=true")) {
				insertProductDataSample();
				insertEmployeeDataSample();
				insertUserDataSample();
				insertCurrencyDataSample();
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
			this.productRepository.save(p);
		}
		Long duration = System.currentTimeMillis() - start;
		log.debug("Insert Sample Product Data." + " (" + duration + "ms)");
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
		log.debug("Insert Sample Data." + " (" + duration + "ms)");
		return 1;
	}

	int insertUserDataSample() {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setUsername("admin");
		user.setPassword("password");
		user.setCreatedDate(new Date());
		user.setActive(1);
		this.userRepository.save(user);
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
		log.debug("Insert Sample Data." + " (" + duration + "ms)");
		return 1;
	}
}
