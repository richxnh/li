package li.aop;

import li.annotation.Bean;
import li.annotation.Inject;
import li.aop.AopChain;
import li.aop.AopFilter;

@Bean
public class LogFilter implements AopFilter {
	@Inject("##############")
	private String msg;

	public void doFilter(AopChain chain) {
		System.err.println("log before " + msg);
		System.err.println(chain.getTarget());
		System.err.println(chain.getMethod());
		for (Object arg : chain.getArgs()) {
			System.out.println("Arg: " + arg);
		}
		for (AopFilter filter : chain.getFilters()) {
			System.out.println("AopFilter: " + filter);
		}
		System.err.println(chain.getProxy());
		chain.doFilter();
		System.err.println(chain.getResult());
		System.err.println("log after");
	}
}