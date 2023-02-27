package com.test.question;

import java.util.Calendar;

public class Q020 {
    /*

    요구사항] 오늘 태어난 아이의 백일과 첫돌을 출력하시오.

    1. 현재 시각 받아오기
    2. add로 100일 후 날짜 구하기 (백일)
    3. 백일 후 날짜 출력
    4. 현재 시각 다시 받아오기
    5. add로 1년 후 날짜 구하기 (첫돌)
    6. 1년 후 첫돌 날짜 출력

     */

    public static void main(String[] args) {

	Calendar now = Calendar.getInstance();

	now.add(Calendar.DATE, 100);
	System.out.printf("백일: %tF\n", now);

	now = Calendar.getInstance();
	now.add(Calendar.YEAR, 1);
	System.out.printf("첫돌: %tF\n", now);

    } //main
}
