package com.test.java;

public class Ex29_if {
    public static void main(String[] args) {

	m1();

    } //main

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
