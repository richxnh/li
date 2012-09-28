package li.dao;

import java.sql.ResultSet;
import java.util.List;

import li.util.Page;

/**
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-09-28)
 */
public class LazyLoadDao<T> extends AbstractDao<T> {
	public List<T> list(Page page, String sql, Object... args) {
		sql = getQueryBuilder().listBySql(page, sql, args);

		QueryRunner queryRunner = new QueryRunner(getConnection());
		ResultSet resultSet = queryRunner.executeQuery(sql);
		ModelBuilder modelBuilder = new LazyLoadModelBuilder(queryRunner, resultSet);

		if (null != resultSet && null != page) {
			page.setRecordCount(count(sql));
		}
		return modelBuilder.list(getType(), getBeanMeta().fields, (null == page ? 18 : page.getPageSize()), true);
	}
}