package com.test.question;

import java.util.Calendar;
import java.util.Scanner;

public class Q034 {

    /*
     
    요구사항]날짜를 입력받아 아래의 조건에 맞게 결과를 출력하시오.
    
    - 입력 받은 날짜가 평일이면 해당 주의 토요일을 알아낸다.
    - 입력 받은 날짜가 토/일요일이면 아무것도 안 한다.
    
    1. 변수 선언
    2. 입력 도구 생성
    3. 라벨 출력 + 년 입력 받기
    4. 라벨 출력 + 월 입력 받기
    5. 라벨 출력 + 일 입력 받기
    6. Calendar.set으로 년월일 설정 후 요일 알아내기
    	- 토요일일 경우: "입력하신 날짜는 '휴일(토/일)'입니다.
    			결과가 없습니다." 출력
     	- 토요일이 아닐 경우: 해당 주의 토요일 출력
    
    */
    
    public static void main(String[] args) {

	int	year = 0,
		month = 0,
		date = 0,
		day = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("년: ");
	year = scan.nextInt();
	
	System.out.print("월: ");
	month = scan.nextInt();
	
	System.out.print("일: ");
	date = scan.nextInt();
	
	Calendar calendar = Calendar.getInstance();
	
	calendar.set(year, month - 1, date);
	
	day = calendar.get(Calendar.DAY_OF_WEEK);
	
	if (day == 7 || day == 1) {
	    System.out.println("입력하신 날짜는 '휴일(토/일)'입니다.");
	    System.out.println("결과가 없습니다.");
	} else {
	    calendar.add(Calendar.DAY_OF_WEEK, 7 - day);
	    
	    System.out.println("입력하신 날짜는 '평일'입니다.");
	    System.out.println("해당 주의 토요일로 이동합니다.");
	    System.out.printf("이동한 날짜는 '%tF'입니다.", calendar);
	}
	
	scan.close();

    } //main
}
