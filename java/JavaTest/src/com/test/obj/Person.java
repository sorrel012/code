package com.test.obj;

public class Person {

	private String name;
	private int age;
	private String address;

//	private String[] nick = 5;; // 굳이 배열 생성x, 어차피 외부에서 배열을 받을 때 참조형이기 때문에 주소 변경

	private String[] nick = new String[5];
	private int index = 0; //별명 배열의 index 제어

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

//	public String[] getNick() {
//		return nick;
//	}
//
//	public void setNick(String[] nick) {
//		this.nick = nick;
//	}

	public void addNick(String nick) {

		if (this.index < this.nick.length) {
			this.nick[this.index] = nick;
			this.index++;

		} else {
			System.out.println("별명을 더이상 추가할 수 없습니다.");
		}

	} //addNick

	public String getNick() {

		//끝에서부터 하나씩 돌려주기
		if(this.index > 0) {

			this.index--;
			return this.nick[this.index];

		} else {
			System.out.println("더이상 별명이 없습니다.");
			return null;
		}

	}

}
