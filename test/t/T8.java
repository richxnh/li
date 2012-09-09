package t;

import li.dao.AbstractDao;
import li.dao.Record;
import li.dao.Trans;
import li.ioc.Ioc;

import com.cduer.forum.record.Account;

public class T8 {
	public static void main(String[] args) throws Throwable {
		final Account accountDao = Ioc.get(Account.class);
		new Trans() {// 开启事务
			public void run() {
				accountDao.update("set email='email_1'");
			}
		};
		accountDao.update("set email='email_2'");
	}

	class BaseDao<T> extends AbstractDao<T> {
	}

	@SuppressWarnings({ "rawtypes" })
	class BaseModel<T extends BaseModel> extends Record<T> {
	}
}