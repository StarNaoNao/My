package com.myIbatis.xuexi;

public class AbstructTest {

	public static void main(String[] args) {
		FemaleStudent fs = new FemaleStudent();
		// 使用在子类中实现了了的抽象方法
		fs.age("11");
		System.out.println(fs.age);
		// 使用抽象类中定义的非抽象方法
		String sex = fs.sex("sex");
		System.out.println(sex);
	}

}
