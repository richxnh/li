package li.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import li.aop.LazyLoadEnhancer;
import li.model.Field;
import li.util.Reflect;

/**
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-09-28)
 */
public class LazyLoadModelBuilder extends ModelBuilder {
	public LazyLoadModelBuilder(QueryRunner queryRunner, ResultSet resultSet) {
		super(queryRunner, resultSet);
	}

	@Override
	public <T> List<T> list(Class<T> type, List<Field> fields, Integer count, Boolean close) {
		List<T> list = new ArrayList<T>();
		try {
			while (null != resultSet && resultSet.next() && (null == count || list.size() <= count)) {
				T t = (T) LazyLoadEnhancer.create(type);
				for (Field attribute : fields) {
					Reflect.set(t, attribute.name, value(attribute.column, false, false));
				}
				list.add(t);
			}
			log.info("builded " + list.size() + " models, types of " + type.getName());
		} catch (Exception e) {
			throw new RuntimeException("Exception at li.dao.ModelBuilder.list()", e);
		} finally {
			if (close) {
				this.close();
			}
		}
		return list;
	}
}