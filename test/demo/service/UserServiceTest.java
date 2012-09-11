package demo.service;

import org.junit.Test;

import demo.model.User;
import demo.service.IUserService;

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