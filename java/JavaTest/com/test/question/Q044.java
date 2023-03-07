package com.test.question;

import java.util.Scanner;

public class Q044 {

    /*

    요구사항] 숫자를 N개 입력받아 아래와 같이 출력하시오.

    1. 변수 선언하기
    2. 입력 도구 생성
    3. while 조건식 반복 > 누적값이 100 넘어가면 종료
    	- 라벨 출력 + 숫자 입력 받기
    	- if로 짝수 홀수 구분하여 누적

     */
    
    public static void main(String[] args) {

	int sum = 0;
	int num = 0;
	String txt = "";
	
	Scanner scan = new Scanner(System.in);
	
	while(sum <= 100) {
	    
	    System.out.print("숫자: ");
	    num = scan.nextInt();
	    
	    if(num % 2 == 0) {
		sum += num;
		txt += " + " + num;
		
	    } else {
		sum -= num;
		txt += " - " + num;
	    }
	    
	}
	
	System.out.printf("%s = %d", txt, sum);
	
	scan.close();

    } //main
    
}
