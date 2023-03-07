package com.test.question;

import java.util.Calendar;

public class Q019 {

    /*

    	요구사항] 현재 시간을 출력하는 메소드를 선언하시오.

    	- void nowTime()
    	- 현재 시간을 24시간으로 출력하시오.
    	- 현재 시간을 오전/오후로 출력하시오.

    	1. 현재 시간 받아오기
    	2. 24시간: HOUR_OF_DAY 사용하여 출력하기
    	3. 오전/오후: AM_PM + 3항 연산자 사용하여 출력하기

     */

    public static void main(String[] args) {

	nowTime();

    } //main

    private static void nowTime() {
	Calendar now = Calendar.getInstance();

	System.out.printf("현재 시간: %d시 %d분 %d초\n"
				, now.get(Calendar.HOUR_OF_DAY)
				, now.get(Calendar.MINUTE)
				, now.get(Calendar.SECOND));

	String amPm = now.get(Calendar.AM_PM) == 0 ? "오전" : "오후";

	System.out.printf("현재 시간: %s %d시 %d분 %d초\n"
				, amPm
				, now.get(Calendar.HOUR_OF_DAY)
				, now.get(Calendar.MINUTE)
				, now.get(Calendar.SECOND));

    } //nowTime
}
