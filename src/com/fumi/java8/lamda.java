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
 *Lambda ��һ���������������ǿ��԰� Lambda 
 *���ʽ���Ϊ��һ�ο��Դ��ݵĴ���
 *(������ ������һ�����д���)��
 *����д������ࡢ�� ���Ĵ��롣
 *��Ϊһ�ָ����յĴ�����ʹ Java�����Ա�������õ���������
 *�Խӿڵ�ʵ��
 * @author zhiwenyan
 *
 */
public class lamda {
	List<Employee> emps = Arrays.asList(
			new Employee(101, "����", 18, 9999.99),
			new Employee(102, "����", 59, 6666.66),
			new Employee(103, "����", 28, 3333.33),
			new Employee(104, "����", 8, 7777.77),
			new Employee(105, "����", 38, 5555.55));
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
	 * �Ż���ʽһ��
	 * �������ģʽ
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
	 * �Ż���ʽ����
	 * �����ڲ���
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
	 * �Ż���ʽ�� lamda���ʽ
	 */
	@Test
	public void test6() {
		List<Employee> employees=filterEmployee(emps,
				(e)->e.getSalary()<5000);
	}
	/**
	 * �Ż���ʽ�� Stream API
	 */
	public void test7() {
		emps.stream()
		.filter((e)->e.getSalary()<5000)
		//����ǰ2��
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
