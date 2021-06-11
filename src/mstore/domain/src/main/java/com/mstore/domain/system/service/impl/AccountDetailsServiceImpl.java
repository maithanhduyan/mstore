package com.mstore.domain.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mstore.domain.system.entity.Account;
import com.mstore.domain.system.entity.Role;
import com.mstore.domain.system.repository.AccountRepository;
import com.mstore.domain.system.repository.AccountRoleExtendRepository;
import com.mstore.domain.system.service.AccountDetailsService;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {
	private static final Logger LOG = LoggerFactory.getLogger(AccountDetailsServiceImpl.class);

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountRoleExtendRepository accountRoleExtendRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = this.accountRepository.findById(username).orElse(null);
		if (account == null) {
			LOG.info("Username Not Found !");
		}

		List<Role> roleList = this.accountRoleExtendRepository.findAllByAccountId(account.getId());

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roleList != null) {
			for (Role role : roleList) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
				grantList.add(authority);
			}
		}
		UserDetails userDetails = (UserDetails) new User(account.getUserName(), account.getEncryptPassword(),
				grantList);
		return userDetails;
	}

}
