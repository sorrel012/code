package com.test.question;

import java.util.Scanner;

/*

요구사항]영단어를 입력받아 분리하시오.

- 합성어를 입력한다.
- 합성어는 파스칼 표기법으로 입력한다.
- 출력은 각 단어를 공백으로 구분한다.

1. 변수 선언
2. 입력 도구 생성
3. 라벨 출력 + 단어 입력 받기
4. for문 + charAt 으로 대소문자 하나하나 구분해주기
	- 첫 번째 글자는 그냥 출력, 그 다음부터 대문자 만나면 그 전에 " " 넣어주기

*/

public class Q087 {

    public static void main(String[] args) {

	String word = "";
	char c = ' ';

	Scanner scan = new Scanner(System.in);

	System.out.print("단어: ");
	word = scan.nextLine();

	System.out.print("결과: ");
	System.out.print(word.charAt(0));

	for(int i = 1; i < word.length(); i++) {
	    c = word.charAt(i);

	    if(c >= 'a' || c > 'z') {
		System.out.print(c);

	    } else {
		System.out.print(" ");
		System.out.print(c);
	    }

	}

	scan.close();

    } //main

}