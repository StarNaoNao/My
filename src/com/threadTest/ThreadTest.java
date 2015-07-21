package com.threadTest;

public class ThreadTest {

	public static void main(String[] args) {

		//第一种创建Thread的方式：直接new继承Thread对象的子对象。
		Thread t1 = new AThread("a thread");
		
		//第二种创建方式：先创建实现了Runnable接口的类，再将该类传到new的thread对象中最参数。
		ARunnable ar = new ARunnable("a runnable thread");
		Thread t2 = new Thread(ar);
		
		t1.start();
		t2.start();
		
		//第三种方式：类似于第二种方式，不过不用创建额外的类。
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("第三种Thread："+Thread.currentThread().getName());
			}
		});
		
		t3.start();
	}


}
