package com.test.obj.constructor;

public class Cup {


	private String color;
	private int size;


	//자바는 개발자가 생성자를 선언하지 않으면, 자동으로 아래의 생성자를 생성함.
	public Cup() {
		this.color = null;
		this.size = 0;
	}

	//생성자 오버로딩
	public Cup(String color) {
		this.color = color;
		this.size = 0;
	}

	public Cup(int size) {
		this.color = null;
		this.size = size;
	}

	public Cup(String color, int size) {
		this.color = color;
		this.size = size;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	//현재 Cup 객체가 가지고 있는 상태를 반환하는 덤프 메소드
	public String info() {

		return "color: " + this.color + "\nsize: " + this.size;
	}


}
