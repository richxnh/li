package li.dao;

import li.annotation.Inject;
import li.test.BaseTest;

import org.junit.Test;

public class DaoOfRecordTest extends BaseTest {
	@Inject
	UserDao userDao;

	User user = new User().set("id", 1).set("username", "u-4-1" + System.currentTimeMillis()).set("password", "p-1").set("email", "e-1");

	@Test
	public void test1() {
		new Trans() {
			public void run() {
				System.out.println("啥都没做");
			}
		};
	}

	@Test
	public void test2() {
		new Trans() {
			public void run() {
				System.out.println("啥都没做");
			}
		};
	}
}