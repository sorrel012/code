package com.test.question;

import java.util.Scanner;

/*

요구사항]입력 받은 금액을 한글로 출력하시오.

- 입력 범위(원): 0 ~ 99,999,999

1. 변수 선언
2. 입력 도구 생성
3. 라벨 출력 + 금액 입력 받기(문자열로 입력 받기)
4. 단위 배열 생성
5. 반복문 i--
    - 숫자 - > 한글 (swtich case)
    - 단위 붙이기

*/

public class Q089 {

    public static void main(String[] args) {

	String price = "";
	String result = "";
	int code = 0;

	Scanner scan = new Scanner(System.in);

	System.out.print("금액(원): ");
	price = scan.nextLine();

	String[] unit = {"", "십", "백", "천", "만", "십", "백", "천",};

	for(int i = price.length()-1; i >= 0; i--) {

	    code = price.charAt(i) - 48;

	    if(code != 0) {
		result = getKorNum(code) + unit[price.length()-1-i] + result;
	    }

	}

	System.out.println("일금 " + result + "원");

	scan.close();

    } //main

    private static String getKorNum(int code) {

	switch(code) {
	case 1 :
	    return "일";
	case 2 :
	    return "이";
	case 3 :
	    return "삼";
	case 4 :
	    return "사";
	case 5 :
	    return "오";
	case 6 :
	    return "육";
	case 7 :
	    return "칠";
	case 8 :
	    return "팔";
	case 9 :
	    return "구";
	}

	return null;
    }

}
