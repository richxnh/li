package com.cduer.forum.dao.impl;

import com.cduer.forum.dao.IUserDao;
import com.cduer.forum.model.User;

import li.annotation.Bean;
import li.dao.AbstractDao;
import li.util.Convert;

@Bean
public class UserDaoImpl extends AbstractDao<User> implements IUserDao {
	public User findByEmail(String email) {
		return super.find("WHERE email=?", email);
	}

	public User findByUsername(String username) {
		return super.find("WHERE username=:username", Convert.toMap(":username", username));
	}
}