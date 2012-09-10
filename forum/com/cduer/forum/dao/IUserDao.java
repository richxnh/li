package com.cduer.forum.dao;

import com.cduer.forum.model.User;

import li.dao.IBaseDao;

public interface IUserDao extends IBaseDao<User> {
	public User findByEmail(String email);

	public User findByUsername(String username);
}