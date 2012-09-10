package com.cduer.forum.service.impl;

import com.cduer.forum.dao.IUserDao;
import com.cduer.forum.model.User;
import com.cduer.forum.service.IUserService;

import li.annotation.Bean;
import li.annotation.Inject;
import li.service.AbstractService;

@Bean
public class UserServiceImpl extends AbstractService<User> implements IUserService {
	@Inject
	IUserDao userDao;

	public Boolean login(User user) {
		User u = userDao.findByUsername(user.getUsername());
		if (null == u) {
			u = userDao.findByEmail(user.getEmail());
			if (null == u) {
				return false;
			}
		}
		return user.getPassword().equals(u.getPassword());
	}
}