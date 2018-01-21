package com.fumi.relfect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class testConstructor {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String className = "com.fumi.relfect.Person";  
	    @SuppressWarnings("unchecked")
		Class<Person> clazz = (Class<Person>) Class.forName(className);  
	    //1.��ȡConstructor����  
	    @SuppressWarnings("unchecked")
		Constructor<Person>[] constructors =  
	           (Constructor<Person>[]) Class.forName(className).getConstructors();  
	  
	    for (Constructor<Person> constructor: constructors) {  
	        System.out.println(constructor);  
	    }  
	    Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);  
	    System.out.println("ָ����-->" + constructor);
	 
	    //2.���ù�������newInstance()������������  
	    Object obj= constructor.newInstance("changwen", 11);  
	    System.out.println(obj.toString());
	}
}
