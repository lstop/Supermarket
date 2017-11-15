package com.lstop.pojo;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Student {
	private int age;
	private boolean sex;
	private int weight;
	public Student() {
		super();
	}
	public Student(int age, boolean sex, int weight) {
		super();
		this.age = age;
		this.sex = sex;
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", sex=" + sex + ", weight=" + weight + "]";
	}
	
}
