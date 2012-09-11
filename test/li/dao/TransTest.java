package li.dao;

import li.annotation.Inject;
import li.test.BaseTest;

import org.junit.Test;

import com.cduer.forum.record.Account;

public class TransTest extends BaseTest {
	@Inject
	Account accountDao;

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