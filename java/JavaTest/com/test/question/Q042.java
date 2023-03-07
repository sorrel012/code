package com.test.question;

public class Q042 {

    /*

    요구사항] 서기 1년 1월 1일부터 오늘까지 며칠째인지 합을 구하시오.

    1. 변수 선언
    2. for문으로, if문으로 윤년/평년 구분
    3. 1년 1월 일 ~ 2022년 12월 31일까지 계산 + 2023년 31일 + 2월 10일
    

     */
    
    public static void main(String[] args) {
	
	int normalYear = 0;
	int leapYear = 0;
	int date = 0;
	
	for(int i = 1; i < 2023; i++) {
	    
	    if (i % 4 != 0) {
		normalYear++;
	    } else if (i % 100 != 0) {
		leapYear++;
	    } else if (i % 400 == 0) {
		leapYear++;
	    } else {
		normalYear++;
	    }
	    
	}
	
	date = (365 * normalYear) + (366 * leapYear) + 31 + 10;
	
	System.out.printf("2023년 2월 10일 %,d일째 되는 날이고 %s요일입니다.", date, getDay(date));
		
    } //main

    private static String getDay(int date) {
	
	switch(date % 7) {
		case 1:
		    return "월";
		case 2:
		    return "화";
		case 3:
		    return "목";
		case 4:
		    return "목";
		case 5:
		    return "금";
		case 6:
		    return "토";
	}
	
	return "일";
    }
    
    
    
    
    
}
