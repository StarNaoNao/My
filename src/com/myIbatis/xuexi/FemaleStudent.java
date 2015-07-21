package com.myIbatis.xuexi;

public class FemaleStudent extends Student {

	String age;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public void age(String args) {
		setAge(args);
	}
}
