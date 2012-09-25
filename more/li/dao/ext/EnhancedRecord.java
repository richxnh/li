package li.dao.ext;

import li.dao.Record;

/**
 * 
 * 改进的ActiveRecord基类
 * 
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-09-25)
 * 
 * @param <K> 主键类型
 * @param <T> 对象类型
 */
public class EnhancedRecord<K, T extends EnhancedRecord> extends Record<T> {
	public T find(K id) {
		return null;
	}

	public Boolean delete(K id) {
		return null;
	}
}