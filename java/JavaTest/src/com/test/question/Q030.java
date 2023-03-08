package com.test.question;

import java.util.Scanner;

public class Q030 {
    
    /*
    
    요구사항]영문자 1개를 입력받아 대/소문자 변환을 한 뒤 출력하시오.
    
    - 유효성 검사를 하시오.(영문자만 입력 가능)
    - 입력: 문자: F
    - 출력: 'F'의 소문자는 'f'입니다.
    
    1. 입력 도구 생성
    2. 라벨 출력 + 영문자 1개 입력 받기
    3. 대<->소 문자 변환 메서드 선언
    4. 영문자면 > 메서드 호출하여 출력 //
       영문자가 아니면 > "영문자만 입력하시오." 출력
    
     */
    
    public static void main(String[] args) {
	
	char inputChar = ' ';
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("문자: ");
	inputChar = scan.nextLine().charAt(0);
	
	isAlphabet(inputChar);
	
	scan.close();

    } //main

    private static void isAlphabet(char inputChar) {
	
	int code = inputChar;
	
	if (code >= 65 && code <= 90) {
	    System.out.printf("'%c'의 소문자는 '%c'입니다.", inputChar, (char)code + 32);
	} else if (code >= 97 && code <= 122) {
	    System.out.printf("'%c'의 대문자는 '%c'입니다.", inputChar, (char)code - 32);
	} else {
	    System.out.println("영문자만 입력하시오.");
	}
	
    } //isAlphbet
    
}
