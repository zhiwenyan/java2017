package com.fumi.java8;
/**
 * ֻ����һ�����󷽷��Ľӿڣ���Ϊ����ʽ�ӿڡ�
 *  �����ͨ�� Lambda ���ʽ�������ýӿڵĶ���(�� Lambda
 *  ���ʽ�׳�һ���ܼ��쳣����ô���쳣��Ҫ��Ŀ��ӿڵĳ��󷽷��Ͻ�������)��
 *  ���ǿ��������⺯��ʽ�ӿ���ʹ�� @FunctionalInterface ע�⣬
 *  ���������Լ�����Ƿ���һ������ʽ�ӿڣ�ͬʱ javadoc Ҳ��� ��һ��������
 *  ˵������ӿ���һ������ʽ�ӿڡ�
 * @author zhiwenyan
 *
 * @param <T>
 */
@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
