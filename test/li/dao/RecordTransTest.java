package li.dao;

import li.annotation.Inject;
import li.test.BaseTest;

import org.junit.Test;

public class RecordTransTest extends BaseTest {
	@Inject
	User userDao;

	@Test
	public void test1() {
		System.out.println(new Trans() {
			public void run() {
				userDao.update(new User().set("username", "u-4" + System.currentTimeMillis()).set("password", "p-1").set("email", "e-1"));
				userDao.update(new User().set("id", 2).set("username", "u-5" + System.currentTimeMillis()).set("password", "p-1").set("email", "e-1"));

				set("haha", "123");
			}
		}.get("haha"));
	}
}