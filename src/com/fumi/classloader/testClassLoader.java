package com.fumi.classloader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * java�������������
 * 
 * @author zhiwenyan
 * 
 *         ClassLoader ��ί�м��ػ���ԭ�� ������ϵͳ�İ�ȫ�� AppClassLoader
 *         ->ExtClassLoader->BootstarpClassLoader
 */
public class testClassLoader {
	public static void main(String[] args) {
		// ��ȡMain�ļ�����
		Class<testClassLoader> main = testClassLoader.class;
		ClassLoader mainClassLoader = main.getClassLoader();
		System.out.println(mainClassLoader);
		System.out.println("*****");
		// ����ص�·�� --->classpath
		URL[] urls = ((URLClassLoader) (mainClassLoader)).getURLs();
		for (URL url : urls) {
			System.out.println(url);
		}
		System.out.println("*****");
		ClassLoader parentClassLoader = mainClassLoader.getParent();
		System.out.println(parentClassLoader);
		System.out.println("*****");

		URL[] urls1 = ((URLClassLoader) (parentClassLoader)).getURLs();
		for (URL url : urls1) {
			System.out.println(url);
		}

		ClassLoader extParentClassLoader = parentClassLoader.getParent();
		System.out.println(extParentClassLoader);

		// ��ӡBootstarpClassLoader�����·��
		try {
			Class<?> launcherClass = Class.forName("sun.misc.Launcher");
			System.out.println(launcherClass.getName());
			Method methodGetClassPath = launcherClass.getDeclaredMethod("getBootstrapClassPath", null);
			if (methodGetClassPath != null) {
				methodGetClassPath.setAccessible(true);
				Object obj = methodGetClassPath.invoke(null, null);
				if (obj != null) {
					Method method = obj.getClass().getDeclaredMethod("getURLs", null);
					if (method != null) {
						method.setAccessible(true);
						URL[] booturl = (URL[]) method.invoke(obj, null);
						for (URL url : booturl) {
							System.out.println(url);
						}
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ArrayList.class.getClassLoader());	}
}
