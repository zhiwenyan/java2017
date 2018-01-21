package com.fumi.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Stream ���������� 1������Stream 2���м���� 3����ֹ���� (�ն˲���)
 * 
 * @author zhiwenyan
 *
 */
public class TestStream {
	List<Employee> emps = Arrays.asList(new Employee(101, "����", 18, 9999.99), new Employee(102, "����", 59, 6666.66),
			new Employee(103, "����", 28, 3333.33), new Employee(104, "����", 8, 7777.77),
			new Employee(105, "����", 38, 5555.55));

	// ����Stream
	@Test
	public void test1() {
		// 1������ͨ��Collectionϵ�м����ṩ��Stream��parallStream
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();
		// 2��ͨ��Arrays�о�̬����stream()��ȡ������
		Employee[] employees = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(employees);
		// 3 ����Stream���о�̬�ķ���of()
		Stream<String> stream3 = Stream.of("1", "2", "3");
		// 4 ����������
		// ����
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
		// stream4.forEach(System.out::println);
		// 5 ����
		Stream.generate(() -> (int) (Math.random() * 100)).limit(5).forEach(System.out::println);
	}

	// Stream���м����
	/**
	 * ����м�����������������γ�һ����ˮ�ߣ�������ˮ ���ϴ�����ֹ������ �����м��������ִ���κεĴ���! ������ֹ����ʱһ����ȫ��������Ϊ��������ֵ����
	 * 
	 * filter(Predicate p) ���� Lambda �� �������ų�ĳЩԪ�ء� distinct() ɸѡ��ͨ����������Ԫ�ص� hashCode()
	 * �� equals() ȥ ���ظ�Ԫ�� limit(long maxSize) �ض�����ʹ��Ԫ�ز��������������� skip(long n)
	 * ����Ԫ�أ�����һ���ӵ���ǰ n ��Ԫ�ص�����������Ԫ�� ���� n ���� �򷵻�һ���������� limit(n) ����
	 */
	@Test
	public void test2() {
		// �м����:����ִ���κβ���
		Stream<Employee> stream = emps.stream().filter(e -> e.getAge() > 35);
		// ��ֹ����:һ����ִ��ȫ�����ݣ�����������ְ��
		stream.forEach(System.out::println);

		// �ڲ�����������������Stream API�������
		Stream<Employee> stream2 = emps.stream().filter((e) -> {
			System.out.println("ִ��Stream API");
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
	 * ӳ��
	 * 
	 * map(Function f) ����һ��������Ϊ�������ú����ᱻӦ�õ�ÿ��Ԫ ���ϣ�������ӳ���һ���µ�Ԫ�ء�
	 * 
	 * flatMap(Function f) ����һ��������Ϊ�����������е�ÿ��ֵ��������һ������Ȼ������������ӳ�һ����
	 * 
	 * ����List�е�add addAll
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
	 * �м����
	 * ���� sorted()-��Ȼ����(Comparable) sorted()-�ƶ�����(Comparator)
	 * 
	 */
	@Test
	public void test6() {
		List<String> lists = Arrays.asList("dd", "aa", "cc", "bb");
		// ��Ȼ����
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
