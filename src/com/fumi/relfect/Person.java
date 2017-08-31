package com.fumi.relfect;

public class Person {
		String name;
		private int age;

		public Person() {
			System.out.println("无参构造器");
		}

		public Person(String name, int age) {
			System.out.println("有参构造器");
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		private void setName(String name) {
			System.out.println(name);
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
		
		}
}
