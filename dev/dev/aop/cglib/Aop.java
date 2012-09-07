//package dev.aop.cglib;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
///**
// * 为一个方法添加Aop，Aop类必须是一个Bean，且必须是AopFilter的子类
// * @author li (limw@w.cn)
// * @version 0.1.1 (2012-05-08)
// */
//
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.METHOD)
//public @interface Aop {
//	/**
//	 * Aop切入类的Bean的类型
//	 */
//	public Class<? extends AopFilter>[] value();
// }