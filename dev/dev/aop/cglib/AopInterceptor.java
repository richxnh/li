//package dev.aop.cglib;
//
//import java.lang.reflect.Method;
//import java.lang.reflect.Modifier;
//import java.util.ArrayList;
//import java.util.List;
//import li.util.Reflect;
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
///**
// * Aop方法拦截器
// * @author li (limw@w.cn)
// * @version 0.1.1 (2012-07-12)
// */
//public class AopInterceptor implements MethodInterceptor {
//
//	private List<AopFilter> filters = new ArrayList<AopFilter>();// Aop插入类列表
//	private Integer index = 0;
//
//	/**
//	 * 绑定Aop对象，被框架调用，你不需要使用
//	 */
//	public static Object enhancer(Object target) {
//		if (!Modifier.isFinal(target.getClass().getModifiers())) {// 如果不是final类
//			Enhancer enhancer = new Enhancer();
//			enhancer.setSuperclass(target.getClass());
//			enhancer.setCallback(new AopInterceptor());
//			return Reflect.copy(target, enhancer.create());
//		}
//		return target;
//	}
//
//	/**
//	 * 通过Aop代理执行切入代码和目标方法
//	 */
//	public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//		Aop aop = method.getAnnotation(Aop.class);
//		if (aop != null) {// 通过@Aop配置的AopFilter
//			for (Class<?> type : aop.value()) {
//				AopFilter aopFilter = (AopFilter) Ioc2.get(type);
//				if (null == aopFilter) {
//					aopFilter = (AopFilter) Reflect.born(type);
//				}
//				aopFilter.setProxy(proxy);
//				filters.add(aopFilter);
//			}
//		}
//		if (method.getAnnotation(Trans.class) != null) {// 通过@Trans配置的TransFilter
//			AopFilter transFilter = new TransFilter();
//			transFilter.setProxy(proxy);
//			filters.add(transFilter);
//		}
//
//		if (index == filters.size())
//			return proxy.invokeSuper(target, args);
//		else {
//			index++;
//			return filters.get(index - 1).invoke(target, method, args);
//		}
//	}
// }