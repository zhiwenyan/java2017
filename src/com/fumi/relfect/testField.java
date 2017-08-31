package com.fumi.relfect;

import java.lang.reflect.Field;

public class testField {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
		Class clazz = Class.forName("com.fumi.relfect.Person");  
		  
	    //1����ȡ�ֶ�  
	    //1.1 ��ȡField������,˽���ֶ�Ҳ�ܻ�ȡ  
	    Field[] fields = clazz.getDeclaredFields();  
	    for (Field field: fields) {  
	        System.out.print(field.getName() + ", ");  
	    }  
	  
	    //1.2 ��ȡָ�����ֵ�Field�������˽�еģ��������4)  
	    Field field = clazz.getDeclaredField("name");  
	    System.out.println("\n��ȡָ��Field��=: " + field.getName());  
	  
	    Person person = new Person("ABC", 12);  
	    //2����ȡָ�������Field��ֵ  
	    Object val = field.get(person);  
	    System.out.println("��ȡָ�������ֶ�'name'��Field��ֵ=�� " + val);  
	  
	    //3������ָ�������Field��ֵ  
	    field.set(person, "changwen2");  
	    System.out.println("����ָ�������ֶ�'name'��Field��ֵ=: " + person.name);  
	  
	    //4�������ֶ���˽�еģ���Ҫ����setAccessible(true)����  
	    Field field2 = clazz.getDeclaredField("age");  
	    field2.setAccessible(true);  
	    System.out.println("��ȡָ��˽���ֶ���=: " + field2.getName());  	
	}
}
