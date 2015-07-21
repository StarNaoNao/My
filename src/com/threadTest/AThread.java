package com.threadTest;

public class AThread extends Thread {

	public AThread(String name) {
		super(name);
	}

	public void run(){
		for(int i = 0;i<2;i++){
			System.out.println("继承Thread的线程名称："+this.getName()+":"+i);
		}
	}
}
