package com.test.question;

public class Student {
	
	private String name;
	private String age;
	private String grade;
	private String classNumber;
	private String number;
	
	public Student() {
		this("미정", 0, 0, 0, 0);
	}

	public Student(String name, int age) {
		this(name, age, 0, 0, 0);
	}
	

	public Student(int grade, int classNumber, int number) {
		this("미정", 0, grade, classNumber, classNumber);
	}
	
	
	public Student(String name, int age, int grade, int classNumber, int number) {
		
		this.name = name;
		
		if(age == 0) {
			this.age = "미정";
			
		} else {
			this.age = String.valueOf(age) + "세";
		}
		
		if(grade == 0) {
			this.grade = "미정";
		} else {
			this.grade = String.valueOf(grade);
		}
		
		if(classNumber == 0) {
			this.classNumber = "미정";
		} else {
			this.classNumber = String.valueOf(classNumber);
		}
		
		if(number == 0) {
			this.number = "미정";
		} else {
			this.number = String.valueOf(number);
		}
		
	}
	
	public String info() {
		
		return String.format("%s(나이: %s, 학년 : %s, 반 : %s, 번호: %s)"
								, this.name
								, this.age
								, this.grade
								, this.classNumber
								, this.number);
	}
}
