package com.test.collection;

import java.util.ArrayList;

public class Ex74 {

	public static void main(String[] args) {

		//선생님 > 3명
		//학생 > 30명
		
		/*
		Teacher t1 = new Teacher("홍길동", "hong", "1111", "국어");
		
		t1.login();
		t1.test();
		t1.check();
		t1.logout();
		
		System.out.println();
		
		Student s1 = new Student("아무개", "test", "1234");
		
		s1.login();
		s1.setKor(100);
		s1.setEng(90);
		s1.setMath(80);
		s1.score();
		s1.logout();
		*/
		
		String[] name1 = {"김", "이", "박", "최", "정", "연", "조", "정", "유", "양" };
		String[] name2 = { "수", "경", "동", "재", "진", "아", "지", "태", "재", "우",
							"소", "기", "연", "효", "정", "우", "현", "채", "수", "원", "민" };
		
		String[] subjects = { "국어", "영어", "수학" };
		
		String temp = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		
		//선생님 배열 > 고정 > 순수 배열
		Teacher[] tlist = new Teacher[3];
		
		for(int i = 0; i < tlist.length; i++) {
			
			String name = "";
			String id = "";
			String pw = "1111";
			
			name = generateName(name1, name2);
			
			id = generateId(temp, id);
			
			tlist[i] = new Teacher(name, id, pw, subjects[i]);
			
		}
		
		//학생 배열 > 고정x > 컬렉션
		ArrayList<Student> slist= new ArrayList<Student>();
		
		for(int i = 0; i < 30; i++) {
			
			String name = "";
			String id = "";
			String pw = "1111";
			
			name = generateName(name1, name2);
			
			id = generateId(temp, id);
			
			slist.add(new Student(name, id, pw));
		}
		
		for(int i = 0; i < slist.size(); i++) {
			slist.get(i).setKor((int)(Math.random() * 41) + 60);
			slist.get(i).setEng((int)(Math.random() * 41) + 60);
			slist.get(i).setMath((int)(Math.random() * 41) + 60);
		}
		
		for (Teacher t : tlist) {
			System.out.println(t);
		}
		System.out.println();
		
		for(Student s : slist) {
			System.out.println(s);
		}
		System.out.println();

	} //main

	private static String generateId(String temp, String id) {
		int max = (int)(Math.random() * 6) + 5; //아이디 길이(5~10)
		
		for(int j = 0; j < max; j++) { //각 유저마다 아이디 길이 랜덤으로 돌림
			id += temp.charAt((int)(Math.random() * temp.length())); //알파벳모음에서 추출
			//Math.random * temp.length() > 배열에서 어떤 알파벳을 추출할지 index를 랜덤으로 생성(0.0 <= index < (double)temp.length)
			//(int)(Math.random * temp.length()) > 실수를 정수로 변환(0 <= index < temp.length)
		}
		return id;
	}

	private static String generateName(String[] name1, String[] name2) {
		return name1[(int)(Math.random() * name1.length)]
				+ name2[(int)(Math.random() * name2.length)]
				+ name2[(int)(Math.random() * name2.length)];
	}
	
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

abstract class AbstractUser implements User {
	private String name;
	private String id;
	private String pw;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}

class Teacher extends AbstractUser {
	
//	private String name;
//	private String id;
//	private String pw;
	private String subject;
	
	public Teacher(String name, String id, String pw, String subject) {
//		this.name = name;
//		this.id	= id;
		
		setName(name);
		setId(id);
		setPw(pw);
		this.setSubject(subject);
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	//디버깅용
	@Override
	public String toString() {
		return "Teacher [name=" + getName() + ", id=" + getId() + ", pw=" + getPw() + ", subject=" + subject + "]";
	}

	@Override
	public void login() {
		System.out.printf("%s(%s) 선생님이 로그인했습니다.\n", getName(), getId());
	}

	@Override
	public void logout() {
		System.out.printf("%s(%s) 선생님이 로그아웃했습니다.\n", getName(), getId());
	}

	@Override
	public void info() {
		System.out.println("[교사 정보]");
		System.out.println("이름: " + getName());
		System.out.println("아이디: " + getId());
		System.out.println("담당 과목: " + this.subject);
	}
	
	public void test() {
		System.out.println("시험을 출제합니다.");
	}
	
	public void check() {
		System.out.println("학생 성적을 점검합니다.");
	}
	
}

class Student extends AbstractUser{
	
//	private String name;
//	private String id;
//	private String pw;

	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, String id, String pw) {
		setName(name);
		setId(id);
		setPw(pw);
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
		return "Student [name=" + getName() + ", id=" + getId() + ", pw=" + getPw() + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + "]";
	}

	@Override
	public void login() {
		System.out.printf("%s(%s) 학생이 로그인했습니다.\n", getName(), getId());
	}

	@Override
	public void logout() {
		System.out.printf("%s(%s) 학생이 로그아웃했습니다.\n", getName(), getId());
	}

	@Override
	public void info() {
		System.out.println("[학생 정보]");
		System.out.println("이름: " + getName());
		System.out.println("아이디: " + getId());
	}
	
	public void score() {
		System.out.printf("[%s 성적]\n", getName());
		System.out.println("국어 " + this.kor);
		System.out.println("영어 " + this.eng);
		System.out.println("수학 " + this.math);
		
	}
}