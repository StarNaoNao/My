package com.aoptag;

public class HelloImpl implements IHello {

	@Override
	public void hello(String name) throws Exception {
		System.out.println("Hello "+ name);  
	}

	@Override
	public void helloAaa(String name) {
		System.out.println("Hello in aaa "+ name);  
	}

	@Override
	public void helloBbb(String name) {
		System.out.println("Hello in bbb "+ name);  
	}

}
