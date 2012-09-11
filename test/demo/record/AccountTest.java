package demo.record;

import static org.junit.Assert.*;
import li.annotation.Inject;
import li.test.BaseTest;

import org.junit.Before;
import org.junit.Test;

import demo.record.Account;

public class AccountTest extends BaseTest {
	@Inject
	Account account;

	@Before
	public void before() {
		assertNotNull(account);
	}

	@Test
	public void testList() {
	}
}