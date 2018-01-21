package com.fumi.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

/**
 * Description:
 *Lambda 是一个匿名函数，我们可以把 Lambda 
 *表达式理解为是一段可以传递的代码
 *(将代码 像数据一样进行传递)。
 *可以写出更简洁、更 灵活的代码。
 *作为一种更紧凑的代码风格，使 Java的语言表达能力得到了提升。
 *对接口的实现
 * @author zhiwenyan
 *
 */
public class lamda {
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55));
	@Test
	public void test1() {
		Comparator<Integer> comparator=new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1,o2);
			}
		};
		Comparator<Integer> comparator2=(x,y)->Integer.compare(x, y);
		TreeSet<Integer> ts=new TreeSet<>(comparator2);
		
		filterEmployee(emps, new FilterEmployeeForAge());
	}
	 
//	public static <T> List<T> asList(T... a) {
//	        return new ArrayList<>(a);
//	    }

	/**
	 * 优化方式一：
	 * 策略设计模式
	 * @param list
	 * @param mPredicate
	 * @return
	 */
	public List<Employee> filterEmployee(List<Employee> list,
			MyPredicate<Employee> mPredicate){
		List<Employee> employees=new ArrayList<>();
		for (Employee employee : list) {
			if(mPredicate.test(employee)) {
				employees.add(employee);
			}
		}
		return employees;
	}

	/**
	 * 优化方式二：
	 * 匿名内部类
	 */
	@Test
	public void test5() {
		List<Employee> employees=filterEmployee(emps,
				new MyPredicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				// TODO Auto-generated method stub
				return t.getSalary()<5000;
			}
		});
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	/**
	 * 优化方式三 lamda表达式
	 */
	@Test
	public void test6() {
		List<Employee> employees=filterEmployee(emps,
				(e)->e.getSalary()<5000);
	}
	/**
	 * 优化方式四 Stream API
	 */
	public void test7() {
		emps.stream()
		.filter((e)->e.getSalary()<5000)
		//限制前2个
		.limit(2)
		.forEach(System.out::println);
		System.out.println("----------");
	
		emps.stream()
		.map(Employee::getName)
		.forEach(System.out::println);
		
	
	}
	@Test
	public void test2() {
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {				
			}
		};
	Runnable mRunnable=()->System.out.println("Hello World");
	}
	
	public static void main(String[] args) {
		
	}
}
