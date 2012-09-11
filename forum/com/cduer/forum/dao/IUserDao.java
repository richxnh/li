package com.cduer.forum.dao;

import com.cduer.forum.model.User;

import li.dao.IBaseDao;

/**
 * 泛型的IBaseDao接口定义了几个基础的Dao方法,你可以选择让你的Dao接口扩展自这个接口
 */
public interface IUserDao extends IBaseDao<User> {
	public User findByEmail(String email);

	public User findByUsername(String username);
}