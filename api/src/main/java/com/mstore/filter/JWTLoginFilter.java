/**
 * @author Mai Thành Duy An
 */
package com.mstore.filter;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mstore.services.TokenAuthenticationService;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	private static final Logger LOG = LoggerFactory.getLogger(JWTLoginFilter.class);

	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		LOG.debug("JWTLoginFilter.attemptAuthentication: username/password= %s,%s", username, password);
		return getAuthenticationManager()
				.authenticate(new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		LOG.debug("JWTLoginFilter.successfulAuthentication:");

		// Write Authorization to Headers of Response.
		TokenAuthenticationService.addAuthentication(response, authResult.getName());

		String authorizationString = response.getHeader("Authorization");

		LOG.debug("Authorization String=" + authorizationString);
	}

}
