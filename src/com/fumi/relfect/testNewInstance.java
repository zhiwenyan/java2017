package com.fumi.relfect;

public class testNewInstance {
	public static void main(String[] args) {
		//
	    //ʹ��Class���newInstance()�����������һ������  
	    //ʵ�ʵ��õ�����Ǹ� �޲����Ĺ������������Ϊʲôд�����ʱ��Ҫдһ���޲����Ĺ����������Ǹ������õģ�  
	    //һ��ģ�һ�����������˴������Ĺ�������ҲҪ����һ���޲����Ĺ�����  
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
