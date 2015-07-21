package com.myIbatis.test;

public class CloneEntity implements Cloneable {

	public String name;

	public String course[];

	public String[] getCourse() {
		return course;
	}

	public void setCourse(String[] course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object clone() {
		CloneEntity o = null;
		try {
			o = (CloneEntity) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
}
