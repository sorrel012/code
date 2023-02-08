package com.test.java;

import java.util.Scanner;

public class Ex29_if {
    public static void main(String[] args) {

//	m1();
//	m2();
//	m3();
//	m4();
	m5();

    } //main

    private static void m5() {

    } //m5

    private static void m4() {

	int sum = 0; //누적 변수

	Scanner scan = new Scanner(System.in);

	System.out.println("A. 무슨 색을 좋아하시나요?");
	System.out.println("1. 노란색");
	System.out.println("2. 빨간색");
	System.out.println("3. 파란색");

	System.out.print("선택: ");

	int sel = scan.nextInt();

	if (sel == 1) {
	    sum += 10;
	} else if (sel == 2) {
	    sum += 5 ;
	} else if (sel == 3) {
	    sum += 3;
	}

	System.out.println();
	System.out.println("A. 무슨 언어을 좋아하시나요?");
	System.out.println("1. C");
	System.out.println("2. PYTHON");
	System.out.println("3. JAVA");

	System.out.print("선택: ");

	sel = scan.nextInt();

	if (sel == 1) {
	    sum += 5;
	} else if (sel == 2) {
	    sum += 10;
	} else if (sel == 3) {
	    sum += 3;
	}

	System.out.println();
	System.out.println("완료되었습니다.");
	System.out.println();

	System.out.println("[결과]");

	if (sum > 15) {
	    System.out.println("당신은 진취적인 개발자입니다.");
	} else if (sum > 10) {
	    System.out.println("당신은 평범한 개발자입니다.");
	} else {
	    System.out.println("다른 일을 찾아보세요^^");
	}

    } //m4

    private static void m3() {

	Scanner scan = new Scanner(System.in);

	System.out.print("몇 시에 일어났습니까?(시): ");
	int hour = scan.nextInt();

	if (hour <= 6) {
	    System.out.println("지하철을 타고 출근힙니다.");
	} else if (hour <= 7) {
	    System.out.println("버스를 타고 출근합니다.");
	} else if (hour <= 9) {
	    System.out.println("택시를 타고 출근합니다.");
	} else {
	    System.out.println("이미 지각입니다. 휴가를 사용합니다.");
	}

    } //m3

    private static void m2() {

	//요구사항] 나이를 입력 받아 성인인지 미성년자인지 출력하기

	Scanner scan = new Scanner(System.in);

	System.out.print("나이: ");
	int age = scan.nextInt();

	System.out.println(age >= 19 ? "성인" : "미성년자");

	if (age >= 19) {
	    System.out.println("성인");
	} else {
	    System.out.println("미성년자");
	}

    } //m2

    private static void m1() {

	if (true) {
	    System.out.println("안녕하세요");
	}


	int n = -10;

	if (n > 0) {
	    System.out.println("양수입니다.1");
	}

	if (n > 0) {
	    System.out.println("양수입니다.2");
	} else {
	    System.out.println("양수가 아닙니다.");
	}

	n = 0;

	if (n > 0) {
	    System.out.println("양수입니다.");
	} else if (n < 0) {
	    System.out.println("음수입니다.");
	} else {
	    System.out.println("0입니다.");
	}

	n = 0;

	if (n > 0) {
	    System.out.println("양수입니다.");
	} else if (n < 0) {
	    System.out.println("음수입니다.");
	} else if (n == 0) {
	    System.out.println("0입니다.");
	} else {
	    System.out.println("잘못 입력하였습니다.");
	}

	System.out.println("프로그램 종료");

    } //m1



}
