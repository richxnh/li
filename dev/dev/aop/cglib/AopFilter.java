//package dev.aop.cglib;
//
//import java.lang.reflect.Method;
//
//import net.sf.cglib.proxy.MethodProxy;
//
///**
// * Aop过滤器
// * @author li (limw@w.cn)
// * @version 0.0.1 (2012.07.10)
// */
//public class AopFilter {
//	/**
//	 * 方法代理
//	 */
//	private MethodProxy proxy;
//
//	/**
//	 * 你可重写这个方法来构造你的Aop类，使用super.invoke()执行原方法，不要用method.invoke()
//	 */
//	public Object invoke(Object target, Method method, Object[] args) {
//		try {
//			return proxy.invokeSuper(target, args);// 执行目标方法
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 设置方法代理，被框架调用，你不需要使用
//	 */
//	protected void setProxy(MethodProxy proxy) {
//		this.proxy = proxy;
//	}
// }