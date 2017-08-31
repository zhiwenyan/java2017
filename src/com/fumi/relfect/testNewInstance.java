package com.fumi.relfect;

public class testNewInstance {
	public static void main(String[] args) {
		//
	    //使用Class类的newInstance()方法创建类的一个对象  
	    //实际调用的类的那个 无参数的构造器（这就是为什么写的类的时候，要写一个无参数的构造器，就是给反射用的）  
	    //一般的，一个类若声明了带参数的构造器，也要声明一个无参数的构造器  
		Class clazz=Person.class;
		Object object=null;
		try {
			object = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(object.toString());
	}
}
