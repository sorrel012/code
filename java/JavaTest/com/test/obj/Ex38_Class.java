package com.test.obj;

public class Ex38_Class {

    public static void main(String[] args) {

	//요구사항] 지도 > 우리집 > 좌표 > 저장 + 사용

	//Case 1.

	//우리집 좌표
	int x = 100;
	int y = 200;

	System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", x, y);

	//마트 좌표
	int x2 = 300;
	int y2 = 400;

	System.out.printf("마트는 [%d, %d]에 위치합니다.\n", x2, y2);
	System.out.println();


	//Case 2. 배열 사용
	// - 간편, 즉시 생성
	// - 데이터 저장 구조 생성 > 관리 용이 + 가독성 향상
	// - However, 각 방의 데이터가 구분이 힘듦. > 요소를 첨자로 구분하기 때문..

	int[] kor = { 100, 90, 80 }; //같은 성질의 데이터(국어 점수) 	> 많이 사용
	int[] score = { 100, 95, 89, 77, 45 }; //1명 점수(과목 5새)> 잘 사용 x


	//우리집
	int[] a1 = { 100, 200 };

	System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", a1[0], a1[1]);

	//마트
	int[] a2 = { 300, 400 };
	System.out.printf("마트는 [%d, %d]에 위치합니다.\n", x2, y2);
	System.out.println();


	//Case 3. 클래스 사용

	//변수 생성
	// - 자료형 변수명;

	int a;

	//우리집
	// 클래스 객체명 = 객체생성 연산자 생성자(); > 클래스의 객체(인스턴스)를 생성
	Point p1 = new Point();

	// '.'  멤버 접근 연산자
	p1.x = 100;
	p1.y = 200;

	System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", p1.x, p1.y);

	//마트
	Point p2 = new Point();

	p2.x = 300;
	p2.y = 400;

	System.out.printf("마트는 [%d, %d]에 위치합니다.\n", p2.x, p2.y);
	System.out.println();
	System.out.println();


	Size s1 = new Size();

	s1.name = "노트북";
	s1.width = 60;
	s1.height = 50;

	System.out.printf("%s[%dcm, %dcm]\n", s1.name, s1.width, s1.height);

	System.out.println();

	//학생점수
	Student0 hong = new Student0();

	hong.name = "홍길동";
	hong.kor = 100;
	hong.eng = 90;
	hong.math = 80;


	//UML, Unified Modeling Language



    } //main

} //class



/* 클래스 선언하기
class 클래스명 {

    //클래스 멤버 선언하기

    public int a;
    public int b;

} */


//좌표값 저장을 위한 클래스
class Point { //사용자 정의 자료형

    public int x;
    public int y;

} // Point


//제품의 크기
class Size {

    public String name;	//제품명
    public int width; 	//너비
    public int height; 	//높이

} //Size

class Student0 {

    public String name;
    public int kor;
    public int eng;
    public int math;

} //Student




