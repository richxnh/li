package li.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-09-28)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface One {
	/**
	 * 进行关联查询时候的SQL
	 */
	public String value();
}