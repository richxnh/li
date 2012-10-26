package li.aop;

import li.annotation.Bean;

@Bean
public class LogFilter implements AopFilter {
    public void doFilter(AopChain chain) {
        System.err.println(chain.getTarget());
        System.err.println(chain.getMethod());
        chain.doFilter();
    }
}