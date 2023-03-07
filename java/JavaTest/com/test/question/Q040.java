package com.test.question;

import java.util.Scanner;

public class Q040 {
    
    /*
    
    요구사항] 아래와 같이 출력하시오.
    
    1. 변수 선언
    2. 입력 도구 생성
    3. 라벨 출력 + 시작 숫자 입력 받기
    4. 라벨 출력 + 종료 숫자 입력 받기
    5. for 문으로 sum에 합 누적하기
    	- if문으로 +일 경우 -일 경우 빼기 (첫 번째는 +!)
  
     */
    
    public static void main(String[] args) {

	int	start = 0,
		end = 0,
		sum = 0;
	String	operator = " + ",
		txt = "";
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("시작 숫자: ");
	start = scan.nextInt();
	
	System.out.print("종료 숫자: ");
	end = scan.nextInt();
	
	for (int i = start; i < end; i++) {
	    
	    if(operator.equals(" + ")) {
		sum += i;
		operator = " - ";
		txt += i + operator;
	    } else {
		sum -= i;
		operator = " + ";
		txt += i + operator;
	    }
	    
	}

	txt += end;
	sum += operator.equals(" + ") ?  end : -end;
	
	System.out.printf("%s = %d", txt, sum);
	
	scan.close();

    } //main

}
