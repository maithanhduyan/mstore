package com.mstore.domain.user.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mstore.domain.user.entity.User;
import com.mstore.domain.user.repository.UserCommandRepository;

@Transactional
@Repository
public class UserCommandRepositoryImpl implements UserCommandRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUsername(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		return (User) session.find(User.class, username);
	}

}
