package dev.aop;

import li.mvc.Context;
import li.util.Reflect;

public class AopInterceptor {
	private AopFilter[] filters = new AopFilter[0];
	private Integer index = 0;

	public AopInterceptor() {
		Aop aop = Context.getAction().actionMethod.getAnnotation(Aop.class);
		if (null != aop && aop.value().length > 0) {
			filters = new AopFilter[aop.value().length];
			for (int i = 0; i < aop.value().length; i++) {
				filters[i] = Reflect.born(aop.value()[i]);
			}
		}
	}

	public Object intercept() {
		System.err.println(filters.length);

		if (index < filters.length) {
			index++;
			return filters[index - 1].next();
		} else {
			return Reflect.invoke(Context.getAction().actionInstance, Context.getAction().actionMethod);
		}
	}
}