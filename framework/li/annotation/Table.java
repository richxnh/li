package li.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记与数据库中一张表相对应的一个类
 * 
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-05-08)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {
	/**
	 * 此类对应于数据库数据表的表名,留空则使用类名
	 */
	public String value() default "";
}