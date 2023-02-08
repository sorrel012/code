package com.test.java;

import java.util.Calendar;
import java.util.Date;

public class Ex28_DateTime {

    public static void main(String[] args) {

//	m1();
//	System.out.println();
//	m2();
//	System.out.println();
//	m3();
//	System.out.println();
//	m4();
//	System.out.println();
//	m5();
//	System.out.println();
//	m6();

	//현재 시각 tick
	Calendar now = Calendar.getInstance();
	System.out.println(now.getTimeInMillis());
	System.out.println(System.currentTimeMillis());

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

	System.out.printf("오늘은 %d년 %02d월 %02d일입니다.\n"
			, c1.get(Calendar.YEAR)
			, c1.get(Calendar.MONTH) + 1
			, c1.get(Calendar.DATE));

	System.out.println();

	//요구사항] "지금은 14시 12분 53초입니다." //24H
	System.out.printf("지금은 %02d시 %02d분 %02d초입니다.\n"
				, c1.get(Calendar.HOUR_OF_DAY)
				, c1.get(Calendar.MINUTE)
				, c1.get(Calendar.SECOND));

	//요구사항] "지금은 오후 2시 12분 53초입니다." //12H
	System.out.printf("지금은 %s %02d시 %02d분 %02d초입니다.\n"
			, c1.get(Calendar.AM_PM) == 0 ? "오전" : "오후"
			, c1.get(Calendar.HOUR)
			, c1.get(Calendar.MINUTE)
			, c1.get(Calendar.SECOND));

	//요구사항] 2023-02-08 > printf()
	System.out.printf("%tF\n", c1);

	//요구사항] 09:22:17 > printf()
	System.out.printf("%tT\n", c1);

	//요구사항] 수요일 > printf()
	System.out.printf("%tA\n", c1);

	//추가] "오늘은 수요일입니다." > 변수 저장
	//String.format() > 모든 환경 사용 가능, 출력용(X), 조작용(O)
	String msg = String.format("오늘은 %tA입니다.", c1);
	String msg1 = String.format("오늘은 %s입니다.", "수요일");

    } //m2

    private static void m3() {

	//현재 시각 만들기
	Calendar now = Calendar.getInstance();

	//특정 시각 만들기 > 원하는 날짜(2023-07-12)
	//1. 현재 시각 만들기
	//2. 원하는 시각으로 수정하기

	Calendar endDate = Calendar.getInstance();

	endDate.set(Calendar.MONTH, 6);
	endDate.set(Calendar.DATE, 12);

	endDate.set(Calendar.HOUR_OF_DAY, 18);
	endDate.set(Calendar.MINUTE, 0);
	endDate.set(Calendar.SECOND, 0);

	System.out.printf("%tF %tT %tA\n", endDate, endDate, endDate);


	Calendar birthday = Calendar.getInstance();

	birthday.set(1998, 0, 17);

	System.out.printf("%tF %tA\n", birthday, birthday);

    } //m3

    private static void m4() {
	// 연산
	Calendar now = Calendar.getInstance();

	System.out.printf("1일차: %tF\n", now);

	now.add(Calendar.DATE, 100); //수정 > now는 더이상 현재 시각x
	System.out.printf("100일 후: %tF\n", now);

	//현재 시점으로부터 100일전?
	now = Calendar.getInstance();
	now.add(Calendar.DATE, -100);
	System.out.printf("100일 전: %tF\n", now);

	//3시간 17분 뒤 영양제 복용
	now = Calendar.getInstance();

	now.add(Calendar.HOUR, 3);
	now.add(Calendar.MINUTE, 17);
	System.out.printf("영양제 복용 시각은: %tT\n", now);


	// 백일 잔치는 언제?
	Calendar birthday = Calendar.getInstance();
	birthday.set(1998, 0, 17);

	birthday.add(Calendar.DATE, 100);
	System.out.printf("나의 100일 잔치는 언제?: %tF\n", birthday);

    } //m4

    private static void m5() {
	// 내가 태어난 시간부터 지금까지 얼마나 지났는지 계산
	Calendar birthday = Calendar.getInstance();
	birthday.set(1998, 01, 17, 04, 59, 00); //태어난 시간

	Calendar now = Calendar.getInstance(); //현재 시간

	System.out.println( (now.getTimeInMillis() - birthday.getTimeInMillis())
								/ 1000 / 60 / 60 / 24 ); // 초 / 분 / 시 / 일

	//크리스마스까지 며칠 남았는지?
	Calendar christmas = Calendar.getInstance();
	christmas.set(2023, 12, 25);

	long span = christmas.getTimeInMillis() - now.getTimeInMillis();

	System.out.printf("올해 크리스마스까지 %d일 남았습니다.\n", span / 1000 / 60 / 60 / 24);

    } //m5

    private static void m6() {
	// 시간 연산
	//2시간 30분 + 10분
	int hour = 2;
	int min = 30;

	min += 10;

	System.out.printf("%d시간 %d분\n", hour, min);

	//2시간 30분 + 40분

	hour = 2;
	min = 30;

	min += 40;

	hour += min / 60;
	min = min % 60;

	System.out.printf("%d시간 %d분\n", hour, min);
    }
}













