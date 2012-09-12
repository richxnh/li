package t;

import java.sql.Connection;

import javax.sql.DataSource;

import li.dao.Page;
import li.dao.Trans;
import li.ioc.Ioc;
import li.model.Action;
import li.mvc.ActionContext;
import li.util.Convert;
import demo.record.Account;

public class T9 {
	public static void main(String[] args) {
	}

	public static void main10(String[] args) {
		f1();
	}

	public static void f1() {
		f2();
	}

	private static void f2() {
		f3();
	}

	private static void f3() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for (StackTraceElement element : stackTraceElements) {
			System.out.print(element.getLineNumber() + "\t");
			System.out.println(element.getClassName() + "." + element.getMethodName() + "()");
		}
	}

	public static void main9(String[] args) {
		final Account accountDao = Ioc.get(Account.class);
		new Trans() {// 开启事务
			public void run() {
				accountDao.update("set email='email_1'");
			}
		};
	}

	public static void main8(String[] args) {
		System.out.println(Convert.toMap(1, null, 3, 4, null, 6, 7, 8));
	}

	public static void main7(String[] args) {
		String path = "/thread-12-9.htm";
		String method = "GET";
		Action action = ActionContext.getInstance().getAction(path, method);
		System.out.println(action);
	}

	public static void main6(String[] args) {
		System.out.println(new Trans(false) {
			public void run() {
				System.out.println(get("key1"));
				System.out.println(get("key2"));
				set("rtn", "rtn~~~");
			}
		}.set("key1", "value1~~~").set("key2", "value2~~~").go().get("rtn"));
	}

	public static void main5(String[] args) {
		new Trans(false) {
			public void run() {
				set("str", "hello world");
			}
		};
	}

	public static void main4(String[] args) throws Exception {
		Account account = Ioc.get(Account.class);
		Page page = new Page();
		for (int i = 0; i < 1000; i++) {
			System.out.println(account.list(page));
			// System.out.println(account.count());
			Thread.sleep(2000);
		}
	}

	public static void main3(String[] args) {
		System.out.println(null == Trans.CONNECTION_MAP.get());
	}

	public static void main2(String[] args) throws Exception {
		for (int i = 0; i < 1000; i++) {
			new Thread() {
				public void run() {
					try {
						Connection connection = Ioc.get(DataSource.class).getConnection();
						System.out.println(connection);
						Thread.sleep(1000 * 1);
						connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				};
			}.start();
			Thread.sleep(1000 * 1);
		}
	}
}