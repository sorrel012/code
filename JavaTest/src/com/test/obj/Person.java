package com.test.obj;

public class Person {

	private String name;
	private int age;
	private String address;

	private String[] nick; // 굳이 배열 생성x, 어차피 외부에서 배열을 받을 때 참조형이기 때문에 주소 변경

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String[] getNick() {
		return nick;
	}

	public void setNick(String[] nick) {
		this.nick = nick;
	}

}
