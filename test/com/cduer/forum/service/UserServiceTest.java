package com.cduer.forum.service;

import org.junit.Test;

import com.cduer.forum.model.User;

import li.annotation.Inject;
import li.test.BaseTest;

public class UserServiceTest extends BaseTest {
	@Inject
	IUserService userService;

	@Test
	public void testLogin() {
		User user = new User();
		user.setUsername("uname");
		user.setPassword("pwd");
		user.setEmail("eml");

		System.out.println(userService.login(user));
	}
}