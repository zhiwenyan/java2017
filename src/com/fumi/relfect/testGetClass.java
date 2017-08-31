package com.fumi.relfect;

/*
 * 
 * ������ƻ�ȡ�������ַ��� 
 */
public class testGetClass {
	public static void main(String[] args) {
	    Class clazz = null;  

	    //1 ֱ��ͨ������.Class�ķ�ʽ�õ�  
	    clazz = Person.class;  
	    System.out.println("ͨ������: " + clazz);  
	    
	    //2 ͨ�������getClass()������ȡ,���ʹ�õ��٣�һ���Ǵ�����Object����֪����ʲô���͵�ʱ����ã�  
	    Object obj = new Person();  
	    clazz = obj.getClass();  
	    System.out.println("ͨ��getClass(): " + clazz);  
	  
	    //3 ͨ��ȫ������ȡ���õıȽ϶࣬�������׳�ClassNotFoundException�쳣  
	    try {
			clazz = Class.forName("com.fumi.relfect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
	    System.out.println("ͨ��ȫ������ȡ: " + clazz);  

	}
}
