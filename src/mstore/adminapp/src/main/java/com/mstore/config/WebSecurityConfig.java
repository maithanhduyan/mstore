package com.mstore.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.mstore.domain.system.service.AccountDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private String[] managerURL = { "/admin" };
	private String[] adminURL = { "/admin" };
	private String[] baseURL = { "/assets/**", "/vendor/**", "/js/**", "/css/**", "/login" };
	private StringBuilder adminRole;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private AccountDetailsService accountDetailsService;

	public WebSecurityConfig() {
		this.adminRole = new StringBuilder();
		this.adminRole.append("ADMIN");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		// Setting Service to find User in the database.
		// And Setting PassswordEncoder
		auth.userDetailsService(accountDetailsService).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		// The pages does not require login
		http.authorizeRequests().antMatchers(baseURL).permitAll();

		// http.authorizeRequests().antMatchers("/**").authenticated();
		// For ADMIN only.

		http.authorizeRequests().antMatchers("/**").hasAnyRole("ADMIN");

		// When the user has logged in as XX.
		// But access a page that requires role YY,
		// AccessDeniedException will be thrown.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Config for Login Form
		http.authorizeRequests().and().formLogin()//
				// Submit URL of login page.
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/login")//
				.defaultSuccessUrl("/dashboard")//
				.failureUrl("/login?error=true")//
				.usernameParameter("username")//
				.passwordParameter("username")
				// Config for Logout Page
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");

		// Config Remember Me.
		http.authorizeRequests().and() //
				.rememberMe().tokenRepository(this.persistentTokenRepository()) //
				.tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
}
