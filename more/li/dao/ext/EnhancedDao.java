package li.dao.ext;

import java.util.List;

import li.dao.AbstractDao;
import li.dao.QueryRunner;
import li.util.Page;

/**
 * 
 * 改进的Dao基类
 * 
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-09-25)
 * 
 * @param <K> 主键类型
 * @param <T> 对象类型
 */
public class EnhancedDao<K, T> extends AbstractDao<T> {
	public T find(K id) {
		List<T> list = list(new Page(1, 1), getQueryBuilder().find(id.toString()));
		return null != list && list.size() > 0 ? list.get(0) : null;
	}

	public Boolean delete(K id) {
		String sql = getQueryBuilder().delete(id.toString());
		QueryRunner queryRunner = new QueryRunner(getConnection());
		return 1 == queryRunner.executeUpdate(sql);
	}
}