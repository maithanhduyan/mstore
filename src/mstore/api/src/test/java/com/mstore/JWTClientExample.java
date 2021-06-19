package com.mstore;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class JWTClientExample {

	static final String URL_LOGIN = "http://localhost:8888/login";
	static final String URL_EMPLOYEES = "http://localhost:8888/api/v1/user/heathCheck";

	// POST Login
	// @return "Authorization string".
	private static String postLogin(String username, String password) {

		// Request Header
		HttpHeaders headers = new HttpHeaders();

		// Request Body
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		parametersMap.add("username", username);
		parametersMap.add("password", password);

		// Request Entity
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parametersMap, headers);

		// RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// POST Login
		ResponseEntity<String> response = restTemplate.exchange(URL_LOGIN, //
				HttpMethod.POST, requestEntity, String.class);

		HttpHeaders responseHeaders = response.getHeaders();

		List<String> list = responseHeaders.get("Authorization");
		return list == null || list.isEmpty() ? null : list.get(0);
	}

	private static void callRESTApi(String restUrl, String authorizationString) {
		// HttpHeaders
		HttpHeaders headers = new HttpHeaders();

		//
		// Authorization string (JWT)
		//
		headers.set("Authorization", authorizationString);
		//
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));

		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);

		// HttpEntity<String>: To get result as String.
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		// RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// Send request with GET method, and Headers.
		ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES, //
				HttpMethod.GET, entity, String.class);

		String result = response.getBody();

		System.out.println(result);

		// Send request with GET method, and Headers.
		ResponseEntity<String> userResponse = restTemplate.exchange(
				"http://127.0.0.1:8888/api/v1/user/fetchById?accountId=43c89fd9-ebcb-481a-bd54-4e4cbdf07dd9", //
				HttpMethod.POST, entity, String.class);

		String userResult = userResponse.getBody();

		System.out.println(entity);
		System.out.println(userResult);
	}

	public static void main(String[] args) {
		String username = "admin";
		String password = "password";

		String authorizationString = postLogin(username, password);

		System.out.println("Authorization String=" + authorizationString);

		// Call REST API:
		callRESTApi(URL_EMPLOYEES, authorizationString);
	}
}
