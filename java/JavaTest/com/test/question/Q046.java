package com.test.question;

import java.util.Scanner;

public class Q046 {

    /*

    요구사항] 숫자를 10개 입력받아 한글로 변환 후 출력하시오.
    
    - 1~9까지만 입력하시오.

    1. 변수 선언
    2. 반복문: 라벨 출력 + 숫자 입력 받기
    3. 1보다 작거나 9보다 크면 다시 입력 받기
    4. 조건문으로 숫자를 한글로 변환하기
    5. 결과 출력하기

     */
    
    public static void main(String[] args) {

	int num = 0;
	
	String result = "";
	
	Scanner scan = new Scanner(System.in);
	
	for(int i = 0; i < 10; i++) {
	    
	    System.out.print("숫자: ");
	    num = scan.nextInt();
	    
	    if(num < 1 || num > 9) {
		System.out.println("1~9까지의 숫자를 입력해 주세요.\n");
		System.out.print("숫자: ");
		num = scan.nextInt();
		
	    }
	    
	    result += numToKor(num);
	}
	
	System.out.println(result);
	
	scan.close();

    } //main

    private static String numToKor(int num) {
	
	String numKor = "";
	
	switch(num) {
	
	case 1:
	    numKor = "일";
	    break;
	case 2:
	    numKor = "이";
	    break;
	case 3:
	    numKor = "삼";
	    break;
	case 4:
	    numKor = "사";
	    break;
	case 5:
	    numKor = "오";
	    break;
	case 6:
	    numKor = "육";
	    break;
	case 7:
	    numKor = "칠";
	    break;
	case 8:
	    numKor = "팔";
	    break;
	case 9:
	    numKor = "구";
	    break;
	}
	
	return numKor;
    }
    
}
