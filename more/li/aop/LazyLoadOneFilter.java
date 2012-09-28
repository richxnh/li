package li.aop;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import li.annotation.One;
import li.dao.LazyLoadModelBuilder;
import li.dao.ModelBuilder;
import li.dao.QueryRunner;
import li.ioc.Ioc;
import li.model.Bean;
import li.util.Reflect;

public class LazyLoadOneFilter implements AopFilter {
	public void doFilter(AopChain chain) {
		String fieldName = chain.getMethod().getName().substring(3, 4).toLowerCase() + chain.getMethod().getName().substring(4);
		Field field = Reflect.getField(chain.getTarget().getClass(), fieldName);
		if (null != field) {
			try {
				DataSource dataSource = Ioc.get(DataSource.class);
				String sql = chain.getMethod().getAnnotation(One.class).value();
				QueryRunner queryRunner = new QueryRunner(dataSource.getConnection());
				ResultSet resultSet = queryRunner.executeQuery(sql);
				ModelBuilder modelBuilder = new LazyLoadModelBuilder(queryRunner, resultSet);
				List<li.model.Field> fields = Bean.getMeta(dataSource, field.getType()).fields;
				List<?> list = modelBuilder.list(field.getType(), fields, 1, true);
				Object value = null == list || list.size() < 1 ? null : list.get(0);
				Reflect.set(chain.getTarget(), fieldName, value);// 设置属性的值
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		chain.doFilter();// 执行原方法
	}
}