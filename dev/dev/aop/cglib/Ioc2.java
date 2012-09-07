//package dev.aop.cglib;
//
//import java.lang.reflect.Type;
//
//import li.ioc.IocContext;
//import li.model.Bean;
//import li.util.Reflect;
//import li.util.Verify;
//
///**
// * Ioc工具类，用于从IocContext中得到一个对象
// * @author li (limw@w.cn)
// * @version 0.1.3 (2012-05-08)
// */
//@SuppressWarnings("unchecked")
//public class Ioc2 {
//	/**
//	 * 若 type 直接匹配一个Bean， 或者匹配到它实现的一个接口，则返回他的实例
//	 */
//	public static <T> T get(Class<T> type) {
//		for (Bean bean : IocContext.getInstance().BEANS) {
//			if (type.isAssignableFrom(bean.type)) {
//				try {
//					return (T) AopInterceptor.enhancer(bean.instance);
//				} catch (Throwable e) {
//					return (T) bean.instance;
//				}
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * 若Bean名称直接匹配则返回
//	 */
//	public static <T> T get(String name) {
//		for (Bean bean : IocContext.getInstance().BEANS) {
//			if (!Verify.isEmpty(name) && bean.name.equals(name)) {
//				try {
//					return (T) AopInterceptor.enhancer(bean.instance);
//				} catch (Throwable e) {
//					return (T) bean.instance;
//				}
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * 返回名称和类型均符合的Bean，若没有，则返回类型符合的一个Bean
//	 */
//	public static <T> T get(Class<T> type, String name) {
//		if (null != name && !name.isEmpty() && null != type) {
//			for (Bean bean : IocContext.getInstance().BEANS) {
//				if (type.isAssignableFrom(bean.type) && bean.name.equals(name)) {
//					try {
//						return (T) AopInterceptor.enhancer(bean.instance);
//					} catch (Throwable e) {
//						return (T) bean.instance;
//					}
//				}
//			}
//		}
//		return Ioc2.get(type); // 若没有名称和类型均符合的Bean，则返回一个类型符合的Bean
//	}
//
//	/**
//	 * 若类型匹配，并且父类泛型参数为genericType，则返回他的实例
//	 * @param genericType Bea泛型类型
//	 */
//	public static <T> T get(Class<T> type, Type genericType) {
//		for (Bean bean : IocContext.getInstance().BEANS) {
//			if (type.isAssignableFrom(bean.type) && null != genericType && genericType.equals(Reflect.actualType(bean.type))) {
//				try {
//					return (T) AopInterceptor.enhancer(bean.instance);
//				} catch (Throwable e) {
//					return (T) bean.instance;
//				}
//			}
//		}
//		return null;
//	}
// }