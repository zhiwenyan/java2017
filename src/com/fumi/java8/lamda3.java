package com.fumi.java8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * java四大内置函数式接口
 * 
 * @author zhiwenyan
 *
 */
public class lamda3 {
	/**
	 * Consumer<T> void accept(); 消费型接口
	 */
	@Test
	public void test1() {
		happy(200000, m -> System.out.println("消费了" + m + "元"));
	}

	public void happy(double money, Consumer<Double> consumer) {
		consumer.accept(money);

	}

	/**
	 * Supplier 供给型接口 T get();
	 */
	@Test
	public void test2() {
		List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));
		for (Integer integer : list) {

			System.out.println(integer);
		}
	}

	public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Integer n = supplier.get();
			list.add(n);
		}
		return list;
	}

	/**
	 * Function<T,R> 函数式接口 R apply(T t);
	 * 
	 */
	@Test
	public void test3() {
		String newHandler = strHandler("\t\t\t Steven  ", str -> str.trim());
		System.out.println(newHandler);
	}

	/**
	 * 对字符串做处理
	 * 
	 * @param str
	 * @param function
	 * @return
	 */
	public String strHandler(String str, Function<String, String> function) {
		return function.apply(str);
	}

	/**
	 * Predicate<T> 断言型接口
	 */
	@Test
	public void test4() {
		List<String> list=strFilter(Arrays.asList("12","Heloo","Hello","str123","1323"), 
				(s)->s.length()>3);
		for (String str : list) {
			System.out.println(str);
		}
	}

	public List<String> strFilter(List<String> list, Predicate<String> predicate) {
		List<String> strList = new ArrayList<>();
		for (String string : strList) {
			if (predicate.test(string)) {
				strList.add(string);
			}
		}
		return strList;
	}

	public static void main(String[] args) {

	}

}
