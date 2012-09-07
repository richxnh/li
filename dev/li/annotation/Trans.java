package li.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解一个需要事务管理的Dao方法
 * 
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-07-10)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Trans {
	// 没有属性
}
