package com.test.java;

public class Ex33_while {
    
    //while, do while
    
    public static void main(String[] args) {

//	m1();
//	m2();
	m3();

    } //main

    private static void m3() {
	
	//요구사항] 1~10까지의 합
	
	int sum = 0;
	
	for(int i = 1; i <= 10; i ++) {
	    sum += i;
	}
	
	System.out.println(sum);
	System.out.println();
	
	
	sum = 0;
	int n = 1;
	
	while (n <= 10) {
	    sum += n;
	    n++;
	}
	
	System.out.println(sum);
	
    } //m3

    private static void m2() {
	
	int num = 10;
	
	while (num < 5) {
	    System.out.println(num);
	    num++;
	}
	System.out.println("while문 끝");
	System.out.println();
	
	
	do {
	    System.out.println(num);
	    num++;
	} while(num < 5);
	System.out.println("do while문 끝");
	
	System.out.println("종료");
	
    } //m2

    private static void m1() {
	
	//요구사항] 1~10까지 출력하시오.
	
		for (int i = 1; i <= 10; i++) { // 초기식; 조건식; 증감식
		    System.out.println(i);
		}
		System.out.println();
		
		
		
		int num = 1; //루프 변수(i 역할) > 초기식
		
		while (num <= 10) { //조건식
		    System.out.println(num);
		    num++; //증감식
		}
		
    } //m1
    
}
