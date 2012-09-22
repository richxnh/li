package li.aop;

import li.dao.Trans;

/**
 * 一个内置的AopFilter,使被包裹的方法在事务中运行
 * 
 * @author li (limw@w.cn)
 * @version 0.1.1 (2012-09-22)
 */
class TransFilter implements AopFilter {
	/**
	 * 用一个li.dao.Trans包裹执行chain.doFilter
	 */
	public void doFilter(final AopChain chain) {
		new Trans() {
			public void run() {
				chain.doFilter();
			}
		};
	}
}