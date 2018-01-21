package com.fumi.java8;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;
/**
 * 左右遇一括号省
 * 左侧推断类型省
 * 
 * lamda表达式需要函数式接口的支持
 * 函数式接口：接口只有一个抽象方法
 * @author zhiwenyan
 *
 */
public class lamda2 {
	/**
	 * 无参、无返回值
	 */
	@Test
	public void test1() {
		Runnable runnable=()->System.out.println("Hello World");
	}
	/**
	 * Lambda 需要一个参数，（）小括号可以不写，无返回值  
	 * 
	 */
	@Test
	public void test2() {
	Consumer<String> consumer=x->System.out.println(x);
	consumer.accept("Steven");
	}
	/**
	 * 有参数，有返回值
	 */
	@Test
	public void test3() {
		Comparator<Integer> comparator1=(x,y)->{
			System.out.println("Hello");
			return Integer.compare(x, y);
		};
		//只有一条语句{} return可以省略 
		Comparator<Integer> comparator=(x,y)-> Integer.compare(x, y);
	}
	/**
	 * lamda的参数数据类型可以不写，因为jvm编译器通过上下文推测出数据类型（类型推断）
	 */
	@Test
	public void test4() {
		Comparator<Integer> comparator=(x,y)-> Integer.compare(x, y);

	}

	public static void main(String[] args) {
		
	}

}
