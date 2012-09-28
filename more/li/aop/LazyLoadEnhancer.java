package li.aop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import li.annotation.Many;
import li.annotation.One;
import li.util.Reflect;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class LazyLoadEnhancer {
	public static Object create(Class<?> type) {
		final Map<Method, List<AopFilter>> filtersMap = new HashMap<>();
		for (Field field : type.getDeclaredFields()) {
			if (null != field.getAnnotation(One.class)) {
				Method getter = Reflect.getMethod(type, "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
				if (null != getter) {
					List<AopFilter> filters = new ArrayList<>();
					filters.add(new LazyLoadOneFilter());
					filtersMap.put(getter, filters);
				}
			}
			if (null != field.getAnnotation(Many.class)) {
				Method getter = Reflect.getMethod(type, "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
				if (null != getter) {
					List<AopFilter> filters = new ArrayList<>();
					filters.add(new LazyLoadManyFilter());
					filtersMap.put(getter, filters);
				}
			}
		}
		// 创建代理
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(type);
		enhancer.setCallback(new MethodInterceptor() {// 设置callback,使用AopChain代理执行方法
			public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				return new AopChain(target, method, args, filtersMap.get(method), proxy).doFilter().getResult();
			}// 使用AopChian代理执行这个方法并返回值
		});
		return enhancer.create();// 创建代理对象
	}
}