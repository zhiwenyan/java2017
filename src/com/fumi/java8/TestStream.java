package com.fumi.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Stream 的三个步骤 1、创建Stream 2、中间操作 3、终止操作 (终端操作)
 * 
 * @author zhiwenyan
 *
 */
public class TestStream {
	List<Employee> emps = Arrays.asList(new Employee(101, "张三", 18, 9999.99), new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33), new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55));

	// 创建Stream
	@Test
	public void test1() {
		// 1、可以通过Collection系列集合提供的Stream或parallStream
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();
		// 2、通过Arrays中静态方法stream()获取数组流
		Employee[] employees = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(employees);
		// 3 创建Stream类中静态的方法of()
		Stream<String> stream3 = Stream.of("1", "2", "3");
		// 4 创建无限流
		// 迭代
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
		// stream4.forEach(System.out::println);
		// 5 生成
		Stream.generate(() -> (int) (Math.random() * 100)).limit(5).forEach(System.out::println);
	}

	// Stream的中间操作
	/**
	 * 多个中间操作可以连接起来形成一个流水线，除非流水 线上触发终止操作， 否则中间操作不会执行任何的处理! 而在终止操作时一次性全部处理，称为“惰性求值”。
	 * 
	 * filter(Predicate p) 接收 Lambda ， 从流中排除某些元素。 distinct() 筛选，通过流所生成元素的 hashCode()
	 * 和 equals() 去 除重复元素 limit(long maxSize) 截断流，使其元素不超过给定数量。 skip(long n)
	 * 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素 不足 n 个， 则返回一个空流。与 limit(n) 互补
	 */
	@Test
	public void test2() {
		// 中间操作:不会执行任何操作
		Stream<Employee> stream = emps.stream().filter(e -> e.getAge() > 35);
		// 终止操作:一次性执行全部内容，即“惰性求职”
		stream.forEach(System.out::println);

		// 内部迭代：迭代操作由Stream API操作完成
		Stream<Employee> stream2 = emps.stream().filter((e) -> {
			System.out.println("执行Stream API");
			return e.getAge() > 35;
		});
		stream2.forEach(System.out::println);
	}

	@Test
	public void test3() {
		emps.stream().filter(e -> e.getAge() > 35).limit(1).forEach(System.out::println);
	}

	@Test
	public void test4() {
		emps.stream().filter(e -> e.getSalary() > 3000).skip(2).forEach(System.out::println);
	}

	/**
	 * 映射
	 * 
	 * map(Function f) 接收一个函数作为参数，该函数会被应用到每个元 素上，并将其映射成一个新的元素。
	 * 
	 * flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 * 
	 * 类似List中的add addAll
	 */
	@Test
	public void test5() {
		List<String> lists = Arrays.asList("aa", "bb", "cc");
		lists.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
		System.out.println("--------");
		emps.stream().map(Employee::getName).forEach(System.out::println);
		System.out.println("---------");

		Stream<Stream<Character>> stream = lists.stream().map(TestStream::filterCharacter);

		// stream.forEach((stream)->stream.forEach(System.out::println));
		lists.stream().flatMap(TestStream::filterCharacter).forEach(System.out::println);
		System.out.println("----------------");	

	}

	public static Stream<Character> filterCharacter(String str) {
		List<Character> list = new ArrayList<>();
		for (Character s : str.toCharArray()) {
			list.add(s);
		}
		return list.stream();
	}

	/**
	 * 中间操作
	 * 排序 sorted()-自然排序(Comparable) sorted()-制定排序(Comparator)
	 * 
	 */
	@Test
	public void test6() {
		List<String> lists = Arrays.asList("dd", "aa", "cc", "bb");
		// 自然排序
		lists.stream().sorted().forEach(System.out::println);
		System.out.println("----------------");
		emps.stream().sorted((e1,e2)->{
			if(e1.getAge()==e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return e1.getAge()+"".compareTo(e2.getAge()+"");
			}
		}).forEach(System.out::println);

	}
	@Test
	public void test7() {
		
	}

}
