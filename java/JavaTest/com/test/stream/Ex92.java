package com.test.stream;

import java.util.HashSet;

public class Ex92 {
	
	public static void main(String[] args) {

//		m1();
		m2();

	} //main

	private static void m2() {
		
		HashSet<String> set1 = new HashSet<String>();
		
		set1.add("강아지");
		set1.add("고양이");
		set1.add("강아지");
		
		System.out.println(set1);
		
		
		HashSet<Student> set2 = new HashSet<Student>();
		
		set2.add(new Student("홍길동", 20, "남자"));
		set2.add(new Student("아무개", 25, "여자"));
		set2.add(new Student("홍길동", 20, "남자")); //equals()로 비교함.
		
		System.out.println(set2);
				
	}

	private static void m1() {
		
		//객체의 유일성
		int n1 = 10;
		int n2 = 10;
		int n3 = 20;
		
		System.out.println(n1 == n2);
		System.out.println(n1 == n3);
		
		String s1 = "홍길동";
		String s2 = "홍길동";
		String s3 = "아무개";
		
		System.out.println(s1 == s2);		//주소값 비교
		System.out.println(s1.equals(s2));	//equlas 메소드 재정의
		System.out.println();
		
		Student t1 = new Student("홍길동", 20, "남자");
		Student t2 = new Student("아무개", 25, "남자");
		Student t3 = new Student("홍길동", 20, "남자");
		
		System.out.println(t1 == t2);		//주소값 비교
		System.out.println(t1.equals(t2));	//주소값 비교
		
		//동명이인
		System.out.println(t1 == t3);
		System.out.println(t1.equals(t3));
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("t1: " + t1.hashCode());
		System.out.println("t2: " + t2.hashCode());
		System.out.println("t3: " + t3.hashCode());
		
	}
	
} //Main

class Student {
	
	private String name;
	private int age;
	private String gender;
	
	public Student(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
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
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	//현재 객체의 메모리 주소값 반환
	@Override
	public int hashCode() {
		return (this.name + this.age + this.gender).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		//이름 == 이름
		//나이 == 나이
		//성별 == 성별
		
		return this.hashCode() == obj.hashCode();
	}
	
}

