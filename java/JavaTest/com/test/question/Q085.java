package com.test.question;

import java.util.Scanner;

/*

요구사항]주민 등록 번호 유효성 검사를 하시오.

- 하이픈 처리'-' > '-'의 입력 유무 상관없이 검사하시오.
- 유효성 공식 처리

1. 변수 선언
2. 입력 도구 생성
3. 라벨 출력 + 주민등록번호 입력 받기
4. contains + replace -> -이 있으면 ""으로 변경 (-삭제)
5. 0~ 7번 자리의 수(charAt) 추출 + for문으로 2~9곱하기 > 누적
6. 8~11번 자리의 수(charAt) 추출 + for문으로 2~5 곱하기 > 누적
7. 누적합 % 11 구하기
	- if 누적합 % 11 >10 이면 -10
8. 유효성 번호(마지막 자리)와 누적합 %11 같은지 확인하여 결과 출력

*/

public class Q085 {

    public static void main(String[] args) {

	String jumin = "";
	int sum = 0;
	int mod = 0;
	int validationNum = 0;
	int lastJumin = 0;

	Scanner scan = new Scanner(System.in);

	System.out.print("주민등록번호: ");
	jumin = scan.nextLine();

	if(jumin.contains("-")) { // - 처리
	   jumin = jumin.replace("-", "");
	}

	validationNum = jumin.charAt(12) - 48; //마지막 자리 유효성 번호

	sum = getSum(jumin);

	mod = sum % 11;

	validationNum = 11 - mod >= 10 ? 11 - mod - 10 : 11 - mod;

	lastJumin = jumin.charAt(12)-48;

	if(validationNum == lastJumin) {
	    System.out.println("올바른 주민등록번호입니다.");

	} else {
	    System.out.println("올바르지 않은 주민등록번호입니다.");
	}

	scan.close();

    } //main

    private static int getSum(String jumin) { //각 자리수별로 곱 구한 후 누적합 반환

	int mul = 0;
	int sum = 0;
	char ch = '\0';

	for(int i = 0; i <= 7; i++) { //0~7번자리

	    ch = jumin.charAt(i);

	    mul = (ch-48) * (i+2);
	    sum += mul;
	}

	for(int i = 8; i <= 11; i++) { //8~11번자리

	    ch = jumin.charAt(i);

	    mul = (ch-48) * (i-6);
	    sum += mul;
	}

	return sum;
    }
}
