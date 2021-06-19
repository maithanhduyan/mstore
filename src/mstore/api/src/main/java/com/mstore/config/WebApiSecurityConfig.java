package com.mstore.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mstore.domain.shared.utils.PasswordUtil;
import com.mstore.domain.system.service.impl.UserDetailsServiceImpl;
import com.mstore.filter.JWTAuthenticationFilter;
import com.mstore.filter.JWTLoginFilter;

@Configuration
public class WebApiSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOG = LoggerFactory.getLogger(WebApiSecurityConfig.class);


	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()//
				.authorizeRequests()
				// No need authentication.
				.antMatchers("/").permitAll() //
				.antMatchers(HttpMethod.POST, "/login").permitAll() //
				.antMatchers(HttpMethod.GET, "/login").permitAll() // For Test on Browser
				// Need authentication.
				// Need authentication.
				// .antMatchers(HttpMethod.POST, "/api/**").hasRole("ROLE_ADMIN")//
				.anyRequest().authenticated()
				//
				.and()
				//
				// Add Filter 1 - JWTLoginFilter
				//
				.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				//
				// Add Filter 2 - JWTAuthenticationFilter
				//
				.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//String password = "password";

		//String encrytedPassword = PasswordUtil.encryt(password);
		//LOG.info("Encoded password of password=" + encrytedPassword);

		//InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> //
		//mngConfig = auth.inMemoryAuthentication();

		// Defines 2 users, stored in memory.
		// ** Spring BOOT >= 2.x (Spring Security 5.x)
		// Spring auto add ROLE_
		//UserDetails u1 = User.withUsername("admin").password(encrytedPassword).roles("ADMIN").build();
		//UserDetails u2 = User.withUsername("user").password(encrytedPassword).roles("USER").build();

		//LOG.info(u1.toString());
		//LOG.info(u2.toString());
		//mngConfig.withUser(u1);
		//mngConfig.withUser(u2);
		
		//
		
		auth.userDetailsService(userDetailsService).passwordEncoder(PasswordUtil.bCryptPasswordEncoder());

	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
}
