package com.test.question;

import java.util.Calendar;
import java.util.Scanner;

public class Q024 {

    /*
    요구사항] 여러 배달 음식을 같은 시간에 받기를 원하는 고객이 있다.
    	고객이 각각의 매장에 몇시에 전화를 해야 모든 음식을 같은 시간에 받을 수 있는지 알려주시오.
    	
    - 전화를 걸면 짜장면은 10분 뒤에 도착합니다.
    - 전화를 걸면 치킨은 18분 뒤 도착합니다.
    - 전화를 걸면 피자는 25분 뒤 도착합니다.
    - 음식을 받기 원하는 시간은 오후 11시 이전에만 가능합니다.(날짜 변경 금지)
    
    음식을 받기 원하는 시각
    시: 17
    분: 35
    
    1. "음식을 받기 원하는 시각" 출력
    2. 라벨 출력 + 시 입력 받기
    3. 라벨 출력 + 분 입력 받기
    4. 각 음식별로 주문해야 하는 시, 분 계산
    	4-1. add 메소드의 매개변수 value에 음수 넣기
    5. if- else로 오후 11시 이전인지 확인하는 메서드 선언
    	5-1. 이후라면 "배달 가능 시간이 지났습니다. 내일 다시 주문해 주세요." 출력
    	5-2. 이전이라면 각 음식별 도착 시, 분 출력

     */
    
    public static void main(String[] args) {
	
	int blackNoodleHour, blackNoodleMinute
		, chickenHour, chickenMinute
		, pizzaHour, pizzaMinute 	= 0;
		
	
	System.out.println("음식을 받기 원하는 시각");
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("시(24시 기준): ");
	int wantHour = scan.nextInt();
	
	System.out.print("분: ");
	int wantMinute = scan.nextInt();

	Calendar time = Calendar.getInstance();
	
	time.set(Calendar.HOUR_OF_DAY, wantHour);
	time.set(Calendar.MINUTE, wantMinute);
	
	time.add(Calendar.MINUTE, -10);
	blackNoodleHour = time.get(Calendar.HOUR_OF_DAY);
	blackNoodleMinute = time.get(Calendar.MINUTE);
	
	time.add(Calendar.MINUTE, 10 - 18);
	chickenHour = time.get(Calendar.HOUR_OF_DAY);
	chickenMinute = time.get(Calendar.MINUTE);
	
	time.add(Calendar.MINUTE, 18 - 25);
	pizzaHour = time.get(Calendar.HOUR_OF_DAY);
	pizzaMinute = time.get(Calendar.MINUTE);
	
	checkCanOrder("짜장면", blackNoodleHour, blackNoodleMinute);
	checkCanOrder("치킨", chickenHour, chickenMinute);
	checkCanOrder("피자", pizzaHour, pizzaMinute);
	
	scan.close();
	
    } //main
    
    private static void checkCanOrder(String food, int hour, int min) {
	
	if(hour >= 23) {
	    System.out.printf("%s: 배달 가능 시간이 지났습니다. 내일 다시 주문해 주세요.\n", food);
	} else {
	    System.out.printf("%s: %d시 %d분\n", food, hour, min);
	}
	
    }
}
