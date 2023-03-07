package com.test.question;

import java.util.Scanner;

/*

요구사항]금지어를 마스킹 처리 하시오.

- 금지어
  ~ 바보
  ~ 멍청이

1. 변수 선언
2. 입력 도구 생성
3. 라벨 출력 + 문장 입력 받기
4. 금지어가 있는지 확인하기 (index가 -1이 아닌지)
	- 없다면 그대로 출력
	- 있다면 금지어를 *로 바꾸기 + 몇 회 마스킹했는지 출력

*/

public class Q088 {

    public static void main(String[] args) {

	String input = "";

	Scanner scan = new Scanner(System.in);

	System.out.print("입력: ");
	input = scan.nextLine();

	checkWord(input);

	scan.close();

    } //main

    private static void checkWord(String input) {

	int index = 0;
	int count = 0;

	String[] words = {"바보", "멍청이"};

	for(int i = 0; i < 2; i++) {

	    while(true) {

		    index = input.indexOf(words[i], index);

		    if (index == -1) {
			break;
		    }

		    count++;

		    index += words[i].length();

	    }

	}

	input = input.replace("바보", "**");
	input = input.replace("멍청이", "***");

	System.out.println(input);
	System.out.printf("금지어를 %d회 마스킹했습니다.", count);
    }

}
