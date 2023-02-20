package com.test.obj.inheritance;

public class Ex54_static {

	/*
	
	1. 클래스 로딩, Class Loading
		- 프로그램을 실행하기 전에, 프로젝트 내의 모든 클래스의 정의를 미리 읽어서 메모리에 올려놓는 작업 > 설계도 인식 작업
		- 설계도를 미리 읽어서 언제든지 사용 가능하게 메모리에 올려놓는 작업
		- 클래스 로딩 과정 중에 클래스 내부에 있는 모든 static 키워드 검색 > 메모리에 구현★★★
		
	2. main 메소드 실행
	
	 */
	
	
	
	public static void main(String[] args) {

		//상황] 학생 3명
		// - "역삼 중학교" > 절대 규칙 > 개명 > "대명 중학교"
		
		Student.setSchool("역삼 중학교");
		
		Student s1 = new Student();
		
		s1.setName("홍길동");
		s1.setAge(15);
//		s1.setSchool("역삼 중학교");


		Student s2 = new Student();

		s2.setName("아무개");
		s2.setAge(14);
//		s2.setSchool("역삼 중학교");


		Student s3 = new Student();
		
		s3.setName("하하하");
		s3.setAge(16);
//		s3.setSchool("역삼 중학교");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

	} //main
	
} //Main

class Student {
	
	private String name;
	private int age;
	
//	private String school;
	private static String school;
	
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
	
	public static String getSchool() {
		return school;
	}

	public static void setSchool(String school) {
		Student.school = school;
	}
	
//	public String getSchool() {
//		return school;
//	}
//
//	public void setSchool(String school) {
//		this.school = school;
//	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + "]";
	}
		
}
