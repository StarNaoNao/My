package com.myIbatis.test.entity;

public class User {

	// 告警信息ID
	private int id;

	// 监控点ID
	private String name;

	// 告警信息
	private int sex;

	// 告警日期
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
