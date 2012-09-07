package com.cduer.forum.record;

import static org.junit.Assert.assertNotNull;
import li.annotation.Inject;
import li.test.BaseTest;

import org.junit.Test;

public class AccountTest extends BaseTest {
	@Inject
	Account account;

	@Test
	public void testList() {
		assertNotNull(account);
	}
}