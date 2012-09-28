package li.aop;

public class LazyLoadManyFilter implements AopFilter {
	public void doFilter(AopChain chain) {
		chain.doFilter();
	}
}