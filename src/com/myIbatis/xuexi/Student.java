package com.myIbatis.xuexi;

public abstract class Student {

	public String ages = "11";

	// 抽象方法体
	public abstract void age(String args);

	// 非抽象方法，不用在子类中再实现，可以直接用
	public String sex(String sex) {
		return sex;
	}

}
