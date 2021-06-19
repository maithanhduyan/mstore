package com.mstore.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.mstore.service.TokenAuthenticationService;

public class JWTAuthenticationFilter extends GenericFilterBean {

	private static final Logger LOG = LoggerFactory.getLogger(JWTAuthenticationFilter.class);
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		LOG.info("JWTAuthenticationFilter.doFilter");
		Authentication authentication = TokenAuthenticationService
				.getAuthentication((HttpServletRequest) servletRequest);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		filterChain.doFilter(servletRequest, servletResponse);
	}
}
