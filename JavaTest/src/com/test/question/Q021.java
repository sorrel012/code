package com.test.question;

import java.util.Calendar;
import java.util.Scanner;

public class Q021 {

    /*

    요구사항]태어난 년도를 입력하면 나이를 출력하시오.

    - 올해를 기준으로 나이를 계산하시오.
    - 내년, 내후년에 실행해도 그때에 맞는 나이를 출력한다.
    - 우리나라 나이로 출력하시오.

    1. 입력 도구 생성
    2. 라벨 출력
    3. 태어난 연도 입력 받기
    4. 현재 시각을 가져온다.
    5. 년도를 추출한다.
    6. 나이를 계산한다.
    7. 계산 결과를 출력한다.

     */

    public static void main(String[] args) {
	
	int birthYear, year, age = 0;

	Scanner scan = new Scanner(System.in);

	System.out.print("태어난 연도: ");
	birthYear = scan.nextInt();

	Calendar now = Calendar.getInstance();

	year = now.get(Calendar.YEAR);
	age = year - birthYear + 1;

	System.out.printf("나이: %d세\n", age);

	scan.close();
	
    } //main
}
