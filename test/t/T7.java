package t;

import javax.sql.DataSource;

import li.dao.QueryBuilder;
import li.ioc.Ioc;

import com.cduer.forum.record.Thread;

public class T7 {
	static QueryBuilder queryBuilder = new QueryBuilder();

	public static void main(String[] args) {

		Thread threadDao = Ioc.get(Thread.class);

		String sql1 = "SELECT t_thread.# as thread_#,t_member.# AS member_# FROM t_thread,t_member WHERE t_thread.id!=1 AND t_thread.member_id=t_member.id";

		String sql2 = "SELECT t_thread.# FROM t_thread";
		String sql3 = "SELECT t_thread.# AS thread_# FROM t_thread";

		String sql4 = "SELECT t_thread.#,t_member.# AS member_# FROM t_thread,t_member";
		System.out.println(queryBuilder.setAlias(Ioc.get(DataSource.class), sql1));
		System.err.println(queryBuilder.setAlias(Ioc.get(DataSource.class), sql2));
		System.out.println(queryBuilder.setAlias(Ioc.get(DataSource.class), sql3));
		System.err.println(queryBuilder.setAlias(Ioc.get(DataSource.class), sql4));

		threadDao.find(sql1);
		threadDao.find(sql2);
		threadDao.find(sql3);
		threadDao.find(sql4);
	}
}