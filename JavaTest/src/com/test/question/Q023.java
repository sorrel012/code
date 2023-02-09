package com.test.question;

import java.util.Calendar;
import java.util.Scanner;

public class Q023 {

    /*
    
    요구사항] 아빠와 딸의 생일을 입력받아 아빠가 딸보다 며칠을 더 살았는지 출력하시오.
    
    1. 입력 도구 생성
    2. 라벨 출력 + 아빠 생일(년) 입력 받기
    3. 라벨 출력 + 아빠 생일(월) 입력 받기
    4. 라벨 출력 + 아빠 생일(일) 입력 받기
    5. 라벨 출력 + 딸 생일(년) 입력 받기
    6. 라벨 출력 + 딸 생일(월) 입력 받기
    7. 라벨 출력 + 딸 생일(일) 입력 받기
    8. 딸 생일 - 아빠 생일 밀리초로 계산하기
    9. 밀리초 일수로 바꾸기
    10. 결과 출력하기
    
     */
    
    public static void main(String[] args) {
	
	int dadYear, dadMonth, dadDate
		, daughterYear, daughterMonth, daughterDate = 0;
	long howLong = 0;
	
	Scanner scan = new Scanner(System.in);
	
	System.out.print("아빠 생일(년): ");
	dadYear = scan.nextInt();
	System.out.print("아빠 생일(월): ");
	dadMonth = scan.nextInt();
	System.out.print("아빠 생일(일): ");
	dadDate = scan.nextInt();
	
	System.out.print("딸 생일(년): ");
	daughterYear = scan.nextInt();
	System.out.print("딸 생일(월): ");
	daughterMonth = scan.nextInt();
	System.out.print("딸 생일(일): ");
	daughterDate = scan.nextInt();
	
	Calendar dadBirthday = Calendar.getInstance();
	dadBirthday.set(dadYear, dadMonth - 1, dadDate);
	
	Calendar daughterBirthday = Calendar.getInstance();
	daughterBirthday.set(daughterYear, daughterMonth - 1, daughterDate);
	
	howLong = daughterBirthday.getTimeInMillis() - dadBirthday.getTimeInMillis();
	
	System.out.printf("아빠는 딸보다 총 %,d일을 더 살았습니다.", howLong / 1000 / 60 / 60 / 24);
	
	scan.close();
	
    } //main
    
}
