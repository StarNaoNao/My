package com.myIbatis.test;

import java.lang.reflect.Method;

public class CloneTest {
	public static void haha() {
		System.out.println("hahhaha");
	}

	public static void main(String[] args) {
		CloneTest.haha(); // 去掉haha方法的static属性，则调用不成功

		try {
			Class myclass = Class.forName("com.myIbatis.test.CloneEntity");
			Method[] method = myclass.getMethods();
			String methodname = method[0].getName();
			System.out.println(methodname);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		CloneEntity ce1 = new CloneEntity();
		CloneEntity ce2 = new CloneEntity();
		ce1.name = "ce1";
		String[] s = { "math", "english", "science" };
		ce1.course = s;

		ce2 = (CloneEntity) ce1.clone();

		ce2.name = "ce2";
		String[] ss = { "english", "math" };
		ce2.course = ss;

		System.out.println(ce1);
		System.out.println(ce2);
		System.out.println(ce1.getName());
		System.out.println(ce2.getName());
		System.out.println(ce1.getCourse()[0]);
		System.out.println(ce2.getCourse()[0]);

	}
}
