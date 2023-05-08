package com.test.java;

import java.util.Scanner;

public class Ex30_If {

    // switch

    public static void main(String[] args) {
	
//	m1();
//	m2();
//	m3();
	m4();
	
    } //main

    private static void m4() {
	
	/*
	 
	요구사항] 인터넷 쇼핑몰 > 상품 구매 > 옵션(패키지)
	1. 노트북
	2. 노트북 + 마우스패드
	3. 노트북 + 마우스 패드 + 웹캠
	
	*/
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("선택(번호): ");
	int option = scan.nextInt();
	
	switch (option) {
	case 3:
	    System.out.println("웹캠");
	case 2:
	    System.out.println("마우스 패드");
	case 1:
	    System.out.println("노트북");
	    break;
	}
	
    } //m4

    private static void m3() {
	
	//요구사항] 사용자가 월을 입력 > 해당 월의 마지막 일은?
	int lastDate = 0;
	
	int month = 5;
	
	switch (month) {
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
	    lastDate = 31;
	    break;
	case 2:
	    lastDate = 28;
	    break;
	case 4:
	case 6:
	case 9:
	case 11:
	    lastDate = 30;
	    break;
	}
	
	System.out.printf("입력한 %d월의 마지막 일은 %d일입니다.", month, lastDate);
	
    } //m3

    private static void m2() {

	//요구사항] 자판기
	// - 메뉴 출력 > 음료 선택 > 가격 출력
	
	Scanner scan = new Scanner(System.in);
	
	System.out.println("=====================");
	System.out.println("        자판기");
	System.out.println("=====================");
	System.out.println("1. 콜라");
	System.out.println("2. 사이다");
	System.out.println("3. 비타 500");
	System.out.println("---------------------");
	System.out.print("선택(번호): ");
	
	String input = scan.nextLine();

	if (input.equals("1")) {
	    System.out.println("700원입니다.");
	} else if (input.equals( "2")) {
	    System.out.println("600원입니다.");
	} else if (input.equals("3")) {
	    System.out.println("500원입니다.");
	}
	
	switch(input) {
	case "1" :
	    System.out.println("700원입니다.");
	    break;
	case "2" :
	    System.out.println("600원입니다.");
	    break;
	case "3" :
	    System.out.println("500원입니다.");
	    break;
	}
	
	
	if (input.equals("1") || input.equals("2")) {
	    System.out.println("700원입니다.");
	} else if (input.equals("3")) {
	    System.out.println("500원입니다.");
	}
	
	switch(input) {
	case "1" :
	case "2" :
	    System.out.println("700원입니다.");
	    break;
	case "3" :
	    System.out.println("500원입니다.");
	    break;
	}
	
    } //m2

    private static void m1() {
	
	//요구사항] 숫자 한 개를 입력 받고 한글로 출력해주기
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("숫자(1~3): ");
	
	int num = scan.nextInt();
	
	if (num == 1) {
	    System.out.println("하나");
	} else if (num == 2) {
	    System.out.println("둘");
	} else if (num == 3) {
	    System.out.println("셋");
	} else {
	    System.out.println("1에서 3 사이의 숫자를 입력해 주세요.");
	}
	
	switch (num) {
	case 1:
	    System.out.println("하나");
    	    break; //swtich문을 벗어나라
	case 2:
	    System.out.println("둘");
    	    break;
	case 3:
	    System.out.println("셋");
    	    break;
    	default:
    	    System.out.println("1에서 3 사이의 숫자를 입력해 주세요.");
    	    break;
	}
	
    } //m1

}
