package com.fumi.java8;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * ����Ӧ�ã���Lamda���е������з����Ѿ�ʵ���ˣ�
 * ���ǿ���ʹ�÷������� �������Ϊ����������Lambda���ʽ���������һ�ֱ�����ʽ
 * 
 
 * ��Ҫ���������ã� ���󣺣�ʵ�������� �ࣺ����̬������ �ࣺ��ʵ��������
 * 
 * ���������� className::new
 * 
 * 
 * @author zhiwenyan
 *
 */
public class TestMethodRef {
	//���󣺣�ʵ��������
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
	//�ࣺ����̬������
	@Test
	public void test3() {
		Comparator<Integer> comparator=(x,y)->Integer.compare(x, y);
		comparator.compare(1, 2);
		Comparator<Integer> comparator2=Integer::compare;
		
	}
	//�ࣺ��ʵ��������
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
