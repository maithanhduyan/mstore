package com.mstore.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.mstore.domain.shared.utils.PasswordUtil;
import com.mstore.domain.system.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static Logger LOG = LoggerFactory.getLogger(WebSecurityConfig.class);

	private String[] baseURL = { "/", "/assets/**", "/vendor/**", "/js/**", "/css/**", "/login" };

	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		LOG.info("Config Global AuthenticationManagerBuilder");

		// Setting Service to find User in the database.
		// And Setting PassswordEncoder
		auth.userDetailsService(userDetailsService).passwordEncoder(PasswordUtil.bCryptPasswordEncoder());

		String password = "admin";

		String encrytedPassword = PasswordUtil.encryt(password);
		LOG.info("Encoded password of admin=" + encrytedPassword);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//
		http.csrf().disable();

		// The pages does not require login
		http.authorizeRequests().antMatchers(baseURL).permitAll();

		// For ADMIN only.
		http.authorizeRequests().antMatchers("/dashboard.html").access("hasRole('ROLE_ADMIN')");

		// When the user has logged in as XX.
		// But access a page that requires role YY,
		// AccessDeniedException will be thrown.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Config for Login Form
		http.authorizeRequests().and().formLogin()//
				// Submit URL of login page.
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/login")//
				.defaultSuccessUrl("/dashboard.html")//
				.failureUrl("/login?error=true")//
				.usernameParameter("username")//
				.passwordParameter("password")
				// Config for Logout Page
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");

		// Config Remember Me.
		http.authorizeRequests().and() //
				.rememberMe().tokenRepository(this.persistentTokenRepository()) //
				.tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//
		if (true) {
			LOG.info("configure AuthenticationManagerBuilder");
			auth.userDetailsService(userDetailsService).passwordEncoder(PasswordUtil.bCryptPasswordEncoder());
		}
	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}

}
