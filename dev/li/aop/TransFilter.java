package li.aop;

import java.lang.reflect.Method;

import li.dao.Trans;

/**
 * 内置的Aop方式支持事务的Filter
 * 
 * @author li (limw@w.cn)
 * @version 0.0.1 (2012.07.10)
 */
public class TransFilter extends AopFilter {
	/**
	 * 缓存Dao返回值
	 */
	private Object result = null;

	/**
	 * 重写的方法调用li.aop.AopFilter.invoke()方法，里面使用了li.dao.Trans
	 */
	@Override
	public Object invoke(final Object target, final Method method, final Object[] args) {
		new Trans() {
			public void run() {
				result = invokeSuper(target, method, args);
			}
		};
		return result;
	}

	/**
	 * 传递父类方法
	 */
	public Object invokeSuper(Object target, Method method, Object[] args) {
		return super.invoke(target, method, args);
	}
}