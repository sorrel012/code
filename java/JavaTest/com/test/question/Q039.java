package com.test.question;

import java.util.Scanner;

public class Q039 {
    
    /*
    요구사항] 아래와 같이 출력하시오.

    1. 변수 선언
    2. 입력 도구 생성
    3. 라벨 출력 + 시작 숫자 입력 받기
    4. 라벨 출력 + 종료 숫자 입력 받기
    5. for 문으로 sum에 합 누적 + 루프 변수 출력
    
    */
    
    public static void main(String[] args) {

	int	start = 0,
		end = 0,
		sum = 0;
	String	txt = "";
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("시작 숫자: ");
	start = scan.nextInt();
	
	System.out.print("종료 숫자: ");
	end = scan.nextInt();
	
	for (int i = start; i < end; i++) {
	    sum += i;
	    txt += i + " + ";
	}
	
	sum += end;
	txt += end;
	
	System.out.printf("%s = %d", txt, sum);
	
	scan.close();

    } //main
	
}
