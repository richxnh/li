package dev.aop;

public class Test {
	@Aop({ LogAopFilter.class })
	public void test() {
		System.err.println("LogAopFilter");
	}
}
