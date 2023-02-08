package com.test.question;

import java.util.Calendar;
import java.util.Scanner;

public class Q022 {

    /*

     요구사항] 남녀 커플의 이름과 만난 날을 입력받아 기념일을 출력하시오.

     1. 입력 도구 생성
     2. 라벨 출력 + 남자 이름 입력 받기
     4. 라벨 출력 + 여자 이름 입력 받기
     5. 라벨 출력 + 만난 연도 입력 받기
     6. 라벨 출력 + 만난 달 입력 받기
     7. 라벨 출력 + 만난 일 입력 받기
     8. "'남자 이름'과(와) '여자 이름'의 기념일" 출력하기
     9. 현재 시각 받아오기
     10. 특정 시각 설정하기
     11. + date 계산하기 (100, 200, 300, 500, 1000)
     12. 5가지 기념일 출력하기

     */

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);

	System.out.print("남자 이름: ");
	String man = scan.nextLine();
	System.out.print("여자 이름: ");
	String woman = scan.nextLine();

	System.out.print("만난 날(년): ");
	int meetYear = scan.nextInt();
	System.out.print("만난 날(월): ");
	int meetMonth = scan.nextInt();
	System.out.print("만난 날(일): ");
	int meetDate = scan.nextInt();

	System.out.printf("'%s'과(와) '%s'의 기념일\n", man, woman);

	Calendar time = Calendar.getInstance();

	time.set(meetYear, meetMonth -1, meetDate);

	System.out.println(time.get(meetDate));

	time.add(Calendar.DATE, 100); //100일
	System.out.printf("100일: %tF\n", time);
	time.add(Calendar.DATE, 100); //200일
	System.out.printf("200일: %tF\n", time);
	time.add(Calendar.DATE, 100); //300일
	System.out.printf("300일: %tF\n", time);
	time.add(Calendar.DATE, 200); //500일
	System.out.printf("500일: %tF\n", time);
	time.add(Calendar.DATE, 500); //1000일
	System.out.printf("1000일: %tF\n", time);

    } //main
}
