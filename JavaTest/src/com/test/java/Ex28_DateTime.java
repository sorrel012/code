package com.test.java;

import java.util.Calendar;
import java.util.Date;

public class Ex28_DateTime {

    public static void main(String[] args) {

	m1();
	m2();

    } //main

    private static void m1() {

	// Date

	Date date = new Date(); //현재 시각을 생성해서 date라는 변수에 담아라 > 현재 컴퓨터로부터

	System.out.println(date);

    } //m1

    private static void m2() {

	//Calendar

	Calendar c1 = Calendar.getInstance();
	System.out.println(c1);
	System.out.println();

	System.out.println(c1.get(Calendar.YEAR)); 		//년도
	System.out.println(c1.get(Calendar.MONTH) + 1);		//월(+1 해야 함)
	System.out.println(c1.get(Calendar.DATE));		//일
	System.out.println(c1.get(Calendar.HOUR));		//시(12H)
	System.out.println(c1.get(Calendar.HOUR_OF_DAY)); 	// > 시(24H) > 회사에서는 대부분 이것 사용
	System.out.println(c1.get(Calendar.MINUTE));		// 분
	System.out.println(c1.get(Calendar.SECOND));		//초
	System.out.println(c1.get(Calendar.MILLISECOND));	//밀리초(1/1000)
	System.out.println(c1.get(Calendar.AM_PM));		//오전(0), 오후(1)

	System.out.println(c1.get(Calendar.DAY_OF_YEAR));	// 올해 중 며칠째?
	System.out.println(c1.get(Calendar.DAY_OF_MONTH));	// 이번 달 중 며칠째?
	System.out.println(c1.get(Calendar.DAY_OF_WEEK));	// 요일 > 일(1) ~ 토(7)

	System.out.println(c1.get(Calendar.WEEK_OF_YEAR));	// 올해 들어 몇 주 차인지?
	System.out.println(c1.get(Calendar.WEEK_OF_MONTH));	// 이번 달의 몇 주 차인지?
	// > 한 달의 마지막 주가 목요일을 포함하고 있지 않다면 다음 달의 첫째 주로 센다.

	System.out.println();

	System.out.printf("오늘은 %d년 %d월 %d일입니다.\n"
				, c1.get(Calendar.YEAR)
				, c1.get(Calendar.MONTH) + 1
				, c1.get(Calendar.DATE));

    } //m2

}
