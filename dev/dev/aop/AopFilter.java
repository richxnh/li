package dev.aop;

public abstract class AopFilter {
	public abstract Object invoke();

	public Object next() {
		System.out.println("dev.aop.AopFilter.next()");
		return null;
	}
}