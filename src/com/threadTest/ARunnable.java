package com.threadTest;

public class ARunnable implements Runnable {

	private String name;
	
	
	public ARunnable(String name) {
		super();
		this.name = name;
	}


	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
            System.out.println("实现Runnable的线程名称："+name + ":" + i);
        }
    }
}


