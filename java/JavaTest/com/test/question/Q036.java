package com.test.question;

import java.util.Scanner;

public class Q036 {

    /*
    
    요구사항] 시작 숫자, 종료 숫자, 증감치를 입력받아 숫자를 순차적으로 출력하시오.
    
    1. 변수 선언
    2. 라벨 출력 + 시작 숫자  입력 받기
    3. 라벨 출력 + 종료 숫자  입력 받기
    4. 라벨 출력 + 증감치 입력 받기
    5. for문 사용하여 출력하기
    
     */
    
    public static void main(String[] args) {

	int 	start = 0,
		end = 0,
		incDec = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("시작 숫자: ");
	start = scan.nextInt();
	
	System.out.print("종료 숫자: ");
	end = scan.nextInt();
	
	System.out.print("증감치: ");
	incDec = scan.nextInt();
	
	for (int i = start; i <= end; i += incDec) {
	    System.out.println(i);
	}
	
	scan.close();

    } //main
}
