package com.test.question;

import java.util.Scanner;

public class Q027 {
    
    /*
    
    요구사항]문자 1개를 입력받아 아래와 같이 출력하시오.
    
    - f, F → Father
    - m, M → Mother
    - s, S → Sister
    - b, B → Brother
    - 유효성 검사를 하시오.(위의 문자가 아닌 문자는 예외 처리)
    
    1. 입력 도구 생성
    2. 라벨 출력 + 문자 입력 받기
    3. 조건문: switch case 이용하여 결과 출력
    
     */
    
    public static void main(String[] args) {

	String inputChar = "";
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("문자: ");
	inputChar = scan.nextLine();
	
	if (inputChar.equals("f") || inputChar.equals("F")) {
	    System.out.println("Father");
	} else if (inputChar.equals("m") || inputChar.equals("M")) {
	    System.out.println("Mother");
	} else if (inputChar.equals("s") || inputChar.equals("S")) {
	    System.out.println("Sister");
	} else if (inputChar.equals("b") || inputChar.equals("B")) {
	    System.out.println("Brother");
	} else {
	    System.out.println("입력한 문자가 올바르지 않습니다.");
	}
	
    } //main
    
}
