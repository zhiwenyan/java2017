package com.fumi.java8;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;
/**
 * ������һ����ʡ
 * ����ƶ�����ʡ
 * 
 * lamda���ʽ��Ҫ����ʽ�ӿڵ�֧��
 * ����ʽ�ӿڣ��ӿ�ֻ��һ�����󷽷�
 * @author zhiwenyan
 *
 */
public class lamda2 {
	/**
	 * �޲Ρ��޷���ֵ
	 */
	@Test
	public void test1() {
		Runnable runnable=()->System.out.println("Hello World");
	}
	/**
	 * Lambda ��Ҫһ������������С���ſ��Բ�д���޷���ֵ  
	 * 
	 */
	@Test
	public void test2() {
	Consumer<String> consumer=x->System.out.println(x);
	consumer.accept("Steven");
	}
	/**
	 * �в������з���ֵ
	 */
	@Test
	public void test3() {
		Comparator<Integer> comparator1=(x,y)->{
			System.out.println("Hello");
			return Integer.compare(x, y);
		};
		//ֻ��һ�����{} return����ʡ�� 
		Comparator<Integer> comparator=(x,y)-> Integer.compare(x, y);
	}
	/**
	 * lamda�Ĳ����������Ϳ��Բ�д����Ϊjvm������ͨ���������Ʋ���������ͣ������ƶϣ�
	 */
	@Test
	public void test4() {
		Comparator<Integer> comparator=(x,y)-> Integer.compare(x, y);

	}

	public static void main(String[] args) {
		
	}

}
