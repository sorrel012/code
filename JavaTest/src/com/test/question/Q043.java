package com.test.question;

import java.util.Scanner;

public class Q043 {

    /*

    요구사항] 컴퓨터가 1~10 사이의 숫자 1개를 생각하면 사용자가 맞추는 프로그램을 구현하시오.
    
    1. 변수 선언하기
    2. 1~10 사이의 난수 한 개 생성하기
    3. 입력 도구 생성
    4. 사용자가 난수를 맞추도록 반복한다. (라벨 출력 + 입력 받기)
    	- 맞추면 프로그램 종료

     */
    
    public static void main(String[] args) {
	
	int randomNum = 0;
	int inputNum = 0;
	int count = 0;
	
	String passFail = "";
	String txt = "";
	
	randomNum = (int)(Math.random() * 10) + 1;
	
	System.out.println("컴퓨터가 1~10 사이의 숫자를 1개 생각했습니다.\n");
	
	txt = String.format("컴퓨터가 생각한 숫자는 %d입니다.", randomNum);
	
	Scanner scan = new Scanner(System.in);
	
	for(int i = 0; i < 10; i++) {
	    
	    System.out.print("숫자: ");
	    inputNum = scan.nextInt();
	    
	    count++;
	    
	    if(inputNum == randomNum) {
		System.out.println("맞았습니다.\n");
		passFail = String.format("정답을 맞추는 데 시도한 횟수는 %d회입니다.\n", count);
		break;
	    }
	    System.out.println("툴렸습니다.\n");
	    passFail = "모든 기회를 실패했습니다.\n";
	}
	
	System.out.println(txt);
	System.out.println(passFail);
	System.out.println("프로그램을 종료합니다.");
	
	

    } //main
    
    
}
