package com.myIbatis.test.action;

import com.myIbatis.test.util.PropertyConfigurer;

public class GetPropertyTest {

	public static void main(String[] args) {
		String s = PropertyConfigurer.getValue("jdbc.driver");
		System.out.println(s);
	}
}
