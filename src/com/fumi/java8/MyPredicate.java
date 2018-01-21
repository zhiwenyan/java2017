package com.fumi.java8;
/**
 * 只包含一个抽象方法的接口，称为函数式接口。
 *  你可以通过 Lambda 表达式来创建该接口的对象。(若 Lambda
 *  表达式抛出一个受检异常，那么该异常需要在目标接口的抽象方法上进行声明)。
 *  我们可以在任意函数式接口上使用 @FunctionalInterface 注解，
 *  这样做可以检查它是否是一个函数式接口，同时 javadoc 也会包 含一条声明，
 *  说明这个接口是一个函数式接口。
 * @author zhiwenyan
 *
 * @param <T>
 */
@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
