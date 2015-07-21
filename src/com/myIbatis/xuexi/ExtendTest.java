package com.myIbatis.xuexi;

class A {
	static {
		System.out.print("1");
	}

	public A() {
		System.out.print("2");
	}
}

class B extends A {
	static {
		System.out.print("a");
	}

	public B() {
		System.out.print("b");
	}
}

/**
 * 类的static 代码段,可以看作是类首次加载(被虚拟机加载)执行的代码,而对于类的加载,首先要执行其基类(父类)的构造,再执行其本身的构造
 * 
 */
public class ExtendTest {
	public static void main(String[] ars) {
		A ab = new B(); // 执行到此处,结果: 1a2b
		System.out.println();
		ab = new B(); // 执行到此处,结果: 1a2b2b
	}
}