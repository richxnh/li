package t;

import li.dao.Trans;
import li.ioc.Ioc;
import li.util.Page;
import demo.record.Account;
import demo.record.Thread;

public class T9 {
	public static void main2(String[] args) {
		Thread dao = Ioc.get(Thread.class);
		Page page = new Page();

		dao.find("WHERE id=?", 1);// 可以省略 SELECT * FROM table 部分
		dao.find("SELECT * FROM table WHERE id=?", 1);

		dao.list(page, "WHERE true");// 可以省略 SELECT * FROM table 部分
		dao.list(page, "SELECT * FROM table WHERE true");
		dao.list(page, "SELECT * FROM table");

		dao.count("WHERE id=?", 1);// 可以省略 SELECT COUNT(*) FROM table 部分
		dao.count("SELECT * FROM table WHERE id=?", 1);
		dao.count("SELECT COUNT(*) FROM table WHERE id=?", 1);

		dao.delete("WHERE id=?", 1);// 可以省略 DELETE FROM table 部分
		dao.delete("DELETE FROM table WHERE id=?", 1);

		dao.update("SET name='NNN' WHERE id=?", 1);// 可以省略 UPDATE table 部分
		dao.update("UPDATE table SET name='NNN' WHERE id=?", 1);

		// 你可以通过SELECT table.# AS t_#的形式为一个表的所有列设值别名

		/*
		 * 处理为 SELECT table.colunm1 AS t_colunm1,table.colunm2 AS t_colunm2 FROM table LIMIT 0,20
		 */
		dao.list(page, "SELECT table.# AS t_# FROM table");

		/*
		 * 处理为 SELECT t_thread.id,t_thread.subject,t_thread.content,t_thread.forum_id ,t_thread.member_id,t_thread.status,t_member.id AS member_id,t_member.status AS member_status,t_member.name AS member_name,t_member.account_id AS member_account_id FROM t_thread,t_member WHERE t_thread.forum_id='1' AND t_thread.member_id=t_member.id LIMIT 0,20
		 */
		dao.list(page, "SELECT t_thread.#," + "t_member.# AS member_# " + "FROM t_thread,t_member " + "WHERE t_thread.forum_id=? " + "AND t_thread.member_id=t_member.id", 1);
	}

	public static void main4(String[] args) throws Exception {
		final Account accountDao = Ioc.get(Account.class);

		for (int i = 0; i < 100; i++) {// 开100个线程
			new java.lang.Thread() {
				public void run() {
					for (int i = 0; i > -1; i++) {// 无限循环
						new Trans() {// 开启事务
							public void run() {
								new Trans() {// 开启事务
									public void run() {
										accountDao.update("set email='email_1'");
									}
								};
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
			java.lang.Thread.sleep(millis.longValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}