package com.cduer.forum.service;

import com.cduer.forum.model.User;

import li.service.IBaseService;

public interface IUserService extends IBaseService<User> {
	public Boolean login(User user);
}