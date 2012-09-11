package t;

import li.dao.Trans;
import li.ioc.Ioc;

import demo.record.Account;

public class T1 {
	public static void main(String[] args) throws Exception {
		final Account accountDao = Ioc.get(Account.class);

		for (int i = 0; i < 100; i++) {// 开100个线程
			new Thread() {
				public void run() {
					for (int i = 0; i > -1; i++) {// 无限循环
						new Trans() {// 开启事务
							public void run() {
								accountDao.update("set email='email_1'");
							}
						};
						accountDao.update("set email='email_2'");
						// thread_sleep(1000 * 6);// 线程内，方法每秒循环一次
					}
				}
			}.start();
			thread_sleep(1000 * 0.5);// 每秒增加一个线程
		}
	}

	public static void thread_sleep(Number millis) {
		try {
			Thread.sleep(millis.longValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}