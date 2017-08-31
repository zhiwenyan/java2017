package com.fumi.relfect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class testMethod {
	public static void main(String[] args) {
		Class<Person> clazz=null;
		clazz=Person.class;
		//1���õ�clazz ��Ӧ����������Щ����,���ܻ�ȡprivate����  
		Method[] methods =clazz.getMethods();  
		System.out.print("getMethods: ");  
		for (Method method : methods){  
			System.out.print(method.getName() + ", ");  
		}  

		//2����ȡ���еķ���(��ֻ��ȡ�����������ķ���������private������  
		Method[] methods2 = clazz.getDeclaredMethods();  
		System.out.print("\ngetDeclaredMethods: ");  
		for (Method method : methods2){  
			System.out.print(method.getName() + ", ");  
		}  

		//3����ȡָ���ķ���  
		Method method=null;
		try {
			method = clazz.getDeclaredMethod("setName",String.class);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//��һ�������Ƿ�������������Ƿ�����Ĳ���  
		System.out.println("\nmethod : " + method);  

		Method method2=null;
		try {
			method2 = clazz.getDeclaredMethod("setName",String.class);
			method2.setAccessible(true);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��һ�������Ƿ�������������Ƿ�����Ĳ���  
		System.out.println("method2: " + method2);  
		//4��ִ�з�����  
		Object obj=null;
		try {
			obj = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		try {
			method2.invoke(obj, "changwen");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
