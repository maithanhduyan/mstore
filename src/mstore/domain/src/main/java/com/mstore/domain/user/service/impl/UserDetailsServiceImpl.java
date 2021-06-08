package com.mstore.domain.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mstore.domain.user.repository.UserCommandRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserCommandRepository userCommandRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.mstore.domain.user.entity.User account = userCommandRepository.findByUsername(username);
		System.out.println("Account= " + account);

		if (account == null) {
			throw new UsernameNotFoundException("User " //
					+ username + " was not found in the database");
		}

		// EMPLOYEE,MANAGER,..
		String role = account.getRole();

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

		// ROLE_EMPLOYEE, ROLE_MANAGER
		GrantedAuthority authority = new SimpleGrantedAuthority(role);

		grantList.add(authority);

		boolean enabled = account.getActive() == 1 ? true : false;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(account.getUsername(), //
				account.getPassword(), enabled, accountNonExpired, //
				credentialsNonExpired, accountNonLocked, grantList);

		return userDetails;
	}

}
