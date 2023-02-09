package com.test.question;

import java.util.Calendar;
import java.util.Scanner;

public class Q032 {
    
/*
    
    요구사항] 주차 요금을 계산하시오.
    
    - 무료 주차: 30분
    - 초과 10분당: 2,000원
    
    1. 변수 선언
    2. 입력 도구 생성
    3. "[들어온 시간]" 출력
    4. 라벨 출력 + 들어온 시간 (시 / 분) 입력 받기
    5. "[나간 시간]" 출력
    6. 라벨 출력 + 나간 시간 (시 / 분) 입력 받기
    7. 요금 계산하기
    	- Calendar.set()로 시간 설정 후 getTimeInMillis() 이용하여 계산
    8. 요금 출력하기
  
    */
    
    public static void main(String[] args) {

	int	inHour = 0,
		inMinute = 0,
		outHour = 0,
		outMinute = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.println("[들어온 시간]");
	
	System.out.print("시: ");
	inHour = scan.nextInt();
	
	System.out.print("분: ");
	inMinute = scan.nextInt();
	
	System.out.println();
	
	System.out.println("[나간 시간]");
	
	System.out.print("시: ");
	outHour = scan.nextInt();
	
	System.out.print("분: ");
	outMinute = scan.nextInt();
		
	System.out.printf("\n주차 요금은 %,d원입니다.\n",
				calParkingFee(inHour, inMinute, outHour, outMinute));
	
	scan.close();

    } //main

    private static long calParkingFee(int inHour, int inMinute, int outHour, int outMinute) {
	
	long parkMinute = 0;
	
	Calendar inTime = Calendar.getInstance();
	
	inTime.set(Calendar.HOUR_OF_DAY, inHour);
	inTime.set(Calendar.MINUTE, inMinute);
	
	
	Calendar outTime =  Calendar.getInstance();
	
	outTime.set(Calendar.HOUR_OF_DAY, outHour);
	outTime.set(Calendar.MINUTE, outMinute);
	
	parkMinute = (outTime.getTimeInMillis() - inTime.getTimeInMillis()) / 1000 / 60 ;
	
	return (parkMinute - 30) / 10 * 2000;
    }
}
