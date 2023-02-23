package com.test.collection;

public class Ex74 {

	public static void main(String[] args) {

		

	} //main
	
} //Main


//온라인 교육] 회원
//1. 선생님
//2. 학생


//부모 역할
//1. 클래스
//2. 추상 클래스
//3. 인터페이스

interface User {
	void login();
	void logout();
	void info();
}

class Teacher implements User{
	
	private String name;
	private String id;
	private String pw;
	private String subject;
	
	public Teacher(String name, String id, String pw, String subject) {
		this.name = name;
		this.id	= id;
		this.setPw(pw);
		this.setSubject(subject);
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	//디버깅용
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", id=" + id + ", pw=" + pw + ", subject=" + subject + "]";
	}

	@Override
	public void login() {
		System.out.printf("%s(%s) 선생님이 로그인했습니다.\n", this.name, this.id);
	}

	@Override
	public void logout() {
		System.out.printf("%s(%s) 선생님이 로그아웃했습니다.\n", this.name, this.id);
	}

	@Override
	public void info() {
		System.out.println("[교사 정보]");
		System.out.println("이름: " + this.name);
		System.out.println("아이디: " + this.id);
		System.out.println("담당 과목: " + this.subject);
	}
	
	public void test() {
		System.out.println("시험을 출제합니다.");
	}
	
	public void check() {
		System.out.println("학생 성적을 점검합니다.");
	}
	
}

class Student implements User{
	
	private String name;
	private String id;
	private String pw;

	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, String id, String pw) {
		this.name = name;
		this.id = id;
		this.setPw(pw);
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", pw=" + pw + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + "]";
	}

	@Override
	public void login() {
		System.out.printf("%s(%s) 학생이 로그인했습니다.\n", this.name, this.id);
	}

	@Override
	public void logout() {
		System.out.printf("%s(%s) 학생이 로그아웃했습니다.\n", this.name, this.id);
	}

	@Override
	public void info() {
		System.out.println("[학생 정보]");
		System.out.println("이름: " + this.name);
		System.out.println("아이디: " + this.id);
	}
	
	public void score() {
		System.out.printf("[ %s 성적]\n", this.name);
		System.out.println("국어 " + this.kor);
		System.out.println("영어 " + this.eng);
		System.out.println("수학 " + this.math);
		
	}
}