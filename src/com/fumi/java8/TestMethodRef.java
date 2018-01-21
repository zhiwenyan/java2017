package com.fumi.java8;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 方法应用：若Lamda体中的内容有方法已经实现了，
 * 我们可以使用方法引用 可以理解为方法引用是Lambda表达式的另外的另一种变现形式
 * 
 
 * 主要有三种引用： 对象：：实例方法名 类：：静态方法名 类：：实例方法名
 * 
 * 构造器引用 className::new
 * 
 * 
 * @author zhiwenyan
 *
 */
public class TestMethodRef {
	//对象：：实例方法名
	@Test
	public void test1() {
		Consumer<String> consumer=x->System.out.println(x);
		PrintStream printStream=System.out;
		Consumer<String> consumer1=printStream::println;
		Consumer<String> consumer2=System.out::println;
		consumer2.accept("1213");
	}
	@Test
	public void test2() {
		Employee employee=new Employee();
		Supplier<String> supplier=()->employee.getName();
		String str=supplier.get();
		System.out.println(str);
		
		Supplier<Integer> supplier2=employee::getAge;
		Integer n=supplier2.get();
		System.out.println(n);
	}
	//类：：静态方法名
	@Test
	public void test3() {
		Comparator<Integer> comparator=(x,y)->Integer.compare(x, y);
		comparator.compare(1, 2);
		Comparator<Integer> comparator2=Integer::compare;
		
	}
	//类：：实例方法名
	public void test4() {
		BiPredicate<String, String> biPredicate=(x,y)->x.equals(y);
		biPredicate.test("1", "1");
		BiPredicate<String, String> biPredicate1=String::equals;
	}
	@Test
	public void test5() {
		Supplier<Employee> eSupplier=()->new Employee();
		Supplier<Employee> sup2=Employee::new;
		Employee employee=sup2.get();
		System.out.println("employee=="+employee);
	}
	
	public static void main(String[] args) {

	}

}
