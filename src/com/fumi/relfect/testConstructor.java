package com.fumi.relfect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class testConstructor {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String className = "com.fumi.relfect.Person";  
	    @SuppressWarnings("unchecked")
		Class<Person> clazz = (Class<Person>) Class.forName(className);  
	    //1.获取Constructor对象  
	    @SuppressWarnings("unchecked")
		Constructor<Person>[] constructors =  
	           (Constructor<Person>[]) Class.forName(className).getConstructors();  
	  
	    for (Constructor<Person> constructor: constructors) {  
	        System.out.println(constructor);  
	    }  
	    Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);  
	    System.out.println("指定的-->" + constructor);
	 
	    //2.调用构造器的newInstance()方法创建对象  
	    Object obj= constructor.newInstance("changwen", 11);  
	    System.out.println(obj.toString());
	}
}
