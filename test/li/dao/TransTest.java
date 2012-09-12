package li.dao;

import li.annotation.Inject;
import li.test.BaseTest;

import org.junit.Test;

import demo.record.Account;

public class TransTest extends BaseTest {
	@Inject
	Account accountDao;

	@Inject
	User userDao;

	@Test
	public void test1() {
		System.out.println(new Trans() {
			public void run() {
				userDao.update(new User().set("id", 2).set("username", "u-5" + System.currentTimeMillis()).set("password", "p-1").set("email", "e-1"));
				userDao.update(new User().set("username", "u-4" + System.currentTimeMillis()).set("password", "p-1").set("email", "e-1"));
				set("haha", "123");
			}
		}.go().get("haha"));
	}

	@Test
	public void testTrans2() {
		new Trans() {
			public void run() {
				System.err.println("trans 4 start");
				accountDao.list(null);
				System.err.println("trans 4 end");
			}
		};
	}

	@Test
	public void testTrans() {
		new Trans() {
			public void run() {
				System.err.println("trans 1 start");
				accountDao.list(null);
				new Trans() {
					public void run() {
						System.err.println("trans 2 start");
						accountDao.list(null);
						new Trans() {
							public void run() {
								System.err.println("trans 3 start");
								accountDao.list(null);
								System.err.println("trans 3 end");
							}
						};
						accountDao.list(null);
						System.err.println("trans 2 end");
					}
				};
				accountDao.list(null);
				System.err.println("trans 1 end");
			}
		};
	}
}