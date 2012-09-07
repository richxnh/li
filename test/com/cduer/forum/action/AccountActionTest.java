package com.cduer.forum.action;

import li.annotation.Inject;
import li.test.BaseActionTest;

import org.junit.Test;

public class AccountActionTest extends BaseActionTest {
	@Inject
	AccountAction accountAction;

	@Test
	public void listTest() {
		// accountAction.list(page);
		System.out.println(request.getAttribute("accounts"));
		System.out.println(request.getSession().getAttribute("page"));
	}
}