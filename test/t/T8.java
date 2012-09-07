package t;

import javax.sql.DataSource;

import li.dao.AbstractDao;
import li.dao.Page;
import li.dao.QueryBuilder;
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
		protected QueryBuilder getQueryBuilder() {
			return new QueryBuilder();
		}
	}

	@SuppressWarnings({ "rawtypes" })
	class BaseModel<T extends BaseModel> extends Record<T> {
		protected QueryBuilder getQueryBuilder() {
			return new QueryBuilder() {
				public String setPage(String sql, Page page) {
					return super.setPage(sql, page);
				}

				public String update(DataSource dataSource, Object object, Class<?> type) {
					return super.update(dataSource, object, type);
				}
			};
		}
	}
}