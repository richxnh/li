package dev.aop;

public class LogAopFilter extends AopFilter {
	public Object invoke() {
		System.err.println("dev.aop.LogAopFilter.invoke()");
		return null;
	}
}