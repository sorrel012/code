package com.test.question;

import java.util.Scanner;

public class Q033 {
    
    /*
    
    요구사항]년도를 입력받아 해당 년도가 '평년' 인지 '윤년' 인지 출력하시오.
    
    a. 년도를 4로 나눈다.
        - 떨어지면 b 검사
        - 떨어지지 않으면 "평년"
    b. 년도를 100으로 나눈다.
        - 떨어지면 c 검사
        - 떨어지지 않으면 "윤년"
    c. 년도를 400으로 나눈다.
        - 떨어지면 "윤년"
        - 떨어지지 않으면 "평년"

    1. 변수 선언
    2. 입력 도구 생성
    3. 라벨 출력 + 년도 입력 받기
    4. 평년인지 윤년인지 확인
    	a. if 4로 나누어 떨어지지 않으면 평년 / else b로 넘어가기
    	b. if 100으로 나누어 떨어지지 않으면 윤년 / else c로 넘어가기
    	c. if 400으로 나누어 떨어지면 윤년 / else 평년
    5. 결과 출력
        
    */
    
    public static void main(String[] args) {

	int year = 0;
	String result = "";
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("연도 입력: ");
	year = scan.nextInt();
	
	if (year % 4 != 0) {
	    result = "평년";
	} else if (year % 100 != 0) {
	    result = "윤년";
	} else if (year % 400 == 0) {
	    result = "윤년";
	} else {
	    result = "평년";
	}
	
	System.out.printf("%d년은 '%s'입니다.", year, result);
	
	scan.close();

    } //main
    
    
}
