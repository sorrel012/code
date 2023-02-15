package com.test.question;

import java.util.Scanner;

/*

요구사항]숫자를 입력 받아 각 자릿수의 수의 합을 구하시오.

1. 변수 선언
2. 입력 도구 생성
3. 라벨 출력 + 숫자 입력 받기
4. for + charAt으로 각 자리 추출하여 txt, sum에 누적

*/

public class Q082 {

    public static void main(String[] args) {

	String num = "";
	StringBuilder txt = new StringBuilder("");
	int sum = 0;

	Scanner scan = new Scanner(System.in);

	System.out.print("숫자: ");
	num = scan.nextLine();

	for(int i = 0; i < num.length(); i++) {

	    char c = num.charAt(i);

	    if(i == num.length() - 1) {
		txt.append(c);
		sum += c - 48;
		break;

	    }

	    txt.append(c);
	    txt.append(" + ");
	    sum += c - 48;

	}

	System.out.printf("결과: %s = %d", txt, sum);

	scan.close();

    } //main

}
