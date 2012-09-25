package li.dao.ext;

import li.dao.AbstractDao;

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
		return null;
	}

	public Boolean delete(K id) {
		return null;
	}
}