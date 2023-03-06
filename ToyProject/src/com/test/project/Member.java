package com.test.project;

public class Member {
	
	private String no;
	private String name;
	private String age;
	private String gender;
	
	public Member(String no, String name, String age, String gender) {
		this.no = no;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "[no=" + no + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
}
