package com.fumi.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import com.fumi.java8.Employee.Status;

public class TestStream2 {
	private List<Employee> emps = Arrays.asList(new Employee(101, "����", 18, 9999.99, Status.BUSY),
			new Employee(102, "����", 59, 6666.66, Status.VOCATION), new Employee(103, "����", 28, 3333.33, Status.FREE),
			new Employee(104, "����", 8, 7777.77, Status.BUSY), new Employee(105, "����", 38, 5555.55, Status.VOCATION));

	/**
	 * allMatch(Predicate p) ����Ƿ�ƥ������Ԫ�� anyMatch(Predicate p) ����Ƿ�����ƥ��һ��Ԫ��
	 * noneMatch(Predicate p) ����Ƿ�û��ƥ������Ԫ�� findFirst() ���ص�һ��Ԫ�� findAny() ���ص�ǰ���е�����Ԫ��
	 */
	@Test
	public void test1() {
		boolean b1 = emps.stream().allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b1);

		boolean b2 = emps.stream().anyMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b2);

		boolean b3 = emps.stream().noneMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b3);

		Optional<Employee> optional = emps.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
				.findFirst();
		System.out.println(optional.get());

		Optional<Employee> optional1 = emps.stream().findAny();
		System.out.println(optional1.get());
	}

	@Test
	public void test2() {
		Long count = emps.stream().count();
		System.out.println("count=" + count);
		Optional<Employee> optional = emps.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.err.println(optional.get());

		Optional<Double> optional2 = emps.stream().map(Employee::getSalary).min(Double::compare);
		System.err.println(optional2.get());
	}

	// ��Լ
	// reduce(T iden, BinaryOperator b)
	// ���Խ�����Ԫ�ط�������������õ�һ��ֵ�� ���� T
	// reduce(BinaryOperator b)
	// ���Խ�����Ԫ�ط�������������õ�һ��ֵ�� ���� Optional<T>
	@Test
	public void test3() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer integer = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println(integer);
		System.out.println("---------------------");

		Optional<Double> op = emps.stream().map(Employee::getSalary).reduce(Double::sum);
	}

	// �ռ�
	// collect(Collector c)
	// ����ת��Ϊ������ʽ������һ�� Collector�ӿڵ� ʵ�֣����ڸ�Stream��Ԫ�������ܵķ���
	@Test
	public void test4() {
		emps.stream().map(Employee::getName)
				// ��Stream��Ԫ��������
				.collect(Collectors.toList()).forEach(System.out::println);
	}

	@Test
	public void test5() {
		// ƽ��ֵ
		Double avg = emps.stream()
				.collect(Collectors.averagingDouble(Employee::getSalary));
		System.err.println("avg=" + avg);
		//�ܺ�
		Double sum = emps.stream()
				.collect(Collectors.summingDouble(Employee::getSalary));
		System.err.println("avg=" +sum);
		//���ֵ
		//��Сֵ  
		//����
		Map<Status, List<Employee>> maps=
				emps.stream().collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println(maps);
		//�༶���� 
//		Map<Status, List<Employee>> maps=
//				emps.stream().collect(Collectors.groupingBy(Employee::getStatus,Collectors.groupingBy(e-)));
//		System.out.println(maps);
	}
	@Test
	public void test6() {
		
	}

}
