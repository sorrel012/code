package com.test.question;

import java.util.Scanner;

/*

요구사항]숫자를 입력받아 3자리마다 ,를 붙이시오.

- %,d 사용금지

1. 변수 선언
2. 입력 도구 생성
3. 라벨 출력 + 숫자 입력 받기 (문자열로 입력 받기)
4. for문 i-- 로 뒤에서부터 숫자 검사
 - i %3 활용하여 ,붙여주기
5. 결과 출력하기

*/

public class Q086 {

    public static void main(String[] args) {

	String num = "";
	String result = "";

	Scanner scan = new Scanner(System.in);

	System.out.print("숫자: ");
	num = scan.nextLine();

	result = addComma(num);

	System.out.printf("결과: %s", result);

	scan.close();

    } //main

    private static String addComma(String num) {

	String txt = "";
	int index = 1;

	for(int i = num.length()-1; i >= 0; i--) {

	    txt = num.charAt(i) + txt;

	    if(index % 3 == 0) {
		txt = ',' + txt;
	    }

	    index++;

	}
	return txt;

    } //addComma

}
