package com.test.question;

import java.util.Scanner;

/*

요구사항]숫자를 입력 받아 각 자릿수의 수의 합을 구하시오.

- 버전2. 자릿수 쪼개지말고 더해보기(20+72+010+2848+9372)

1. 변수 선언
2. 입력 도구 생성
3. 라벨 출력 + 문장 입력 받기
4. for + charAt으로 숫자 각 자리별로 추출하여 sum에 누적
5. 결과 출력

*/

public class Q090 {

    public static void main(String[] args) {

	String input = "";
	int sumCipher = 0;
	int sum = 0;

	Scanner scan = new Scanner(System.in);

	System.out.print("입력: ");
	input = scan.nextLine();

	sum = getSum(input);

	System.out.printf("문장에 존재하는 모든 숫자의 합은 %d입니다.", sum);

	scan.close();

    } //main

    private static int getSum(String input) {

	char num = ' ';
	int sum = 0;

	for(int i = 0; i < input.length(); i++) {

	    num = input.charAt(i);

	    if(num >= '0' && num <= '9') { //숫자 문자코드 48~57
		sum += (num - 48);

	    }

	}

	return sum;
    } //getSum


}
