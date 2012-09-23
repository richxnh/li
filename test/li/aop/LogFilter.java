package li.aop;

import li.annotation.Bean;
import li.annotation.Inject;

@Bean
public class LogFilter implements AopFilter {
	@Inject("##############")
	private String msg;

	public void doFilter(AopChain chain) {
		System.err.println("log before " + msg);
		System.err.println(chain.getTarget());
		System.err.println(chain.getTarget().getClass());
		System.err.println(chain.getTarget().getClass().getSuperclass());
		System.err.println(chain.getMethod());
		for (Object arg : chain.getArgs()) {
			System.out.println("Arg: " + arg);
		}
		chain.doFilter();
		System.err.println(chain.getResult());
		System.err.println("log after");
	}
}